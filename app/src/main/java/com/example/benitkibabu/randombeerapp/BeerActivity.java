package com.example.benitkibabu.randombeerapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.benitkibabu.randombeerapp.models.Beer;
import com.example.benitkibabu.randombeerapp.models.Labels;
import com.example.benitkibabu.randombeerapp.models.SearchResult;
import com.example.benitkibabu.randombeerapp.rest.ApiClient;
import com.example.benitkibabu.randombeerapp.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerActivity extends AppCompatActivity {
    final String TAG = this.getClass().getName();

    ImageView labelView;
    TextView title, descriptionText;

    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        labelView = (ImageView) findViewById(R.id.labelView);
        title = (TextView) findViewById(R.id.title);
        descriptionText = (TextView) findViewById(R.id.descriptionText) ;
        pb = (ProgressBar) findViewById(R.id.progressBar);

        getRandomBeer();

        FloatingActionButton nextButton = (FloatingActionButton) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomBeer();
            }
        });
    }

    void getRandomBeer(){
        showProgressBar();
        ApiInterface apiService = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<SearchResult> call = apiService.getBeer(getString(R.string.BreweryAPI_KEY), "Y");
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                hideProgressBar();
                if(response.isSuccessful()) {
                    Beer beer = response.body().getData();
                    Labels labels = beer.getLabel();

                    title.setText(beer.getName());

                    if (beer.getDescription() == null || beer.getDescription().isEmpty())
                        descriptionText.setText("No Description");
                    else
                        descriptionText.setText(beer.getDescription());

                    Picasso.with(BeerActivity.this).load(labels.getLarge())
                            .placeholder(R.drawable.prorgress_animation)
                            .resize(512, 512)
                            .centerCrop()
                            .into(labelView);

                    Log.d(TAG, response.body().getStatus());
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable throwable) {
                hideProgressBar();
                Log.e(TAG, throwable.toString());
            }
        });
    }

    void showProgressBar(){
        if(pb !=null)
            pb.setVisibility(View.VISIBLE);
    }

    void hideProgressBar(){
        if(pb !=null)
            pb.setVisibility(View.INVISIBLE);
    }


    //When we resume the application, recall the getRandomBeer() method to generate a new random beer
    @Override
    protected void onResume() {
        super.onResume();
        getRandomBeer();
    }
}
