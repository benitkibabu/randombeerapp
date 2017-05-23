package com.example.benitkibabu.randombeerapp.rest;

import com.example.benitkibabu.randombeerapp.models.Beer;
import com.example.benitkibabu.randombeerapp.models.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Benit Kibabu on 23/05/2017.
 */

public interface ApiInterface {
    @GET("beer/random/")
    Call<SearchResult> getBeer(@Query("key") String apiKey, @Query("hasLabels") String hasLabels);
}
