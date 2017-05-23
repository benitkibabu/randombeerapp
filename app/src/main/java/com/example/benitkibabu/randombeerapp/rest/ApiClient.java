package com.example.benitkibabu.randombeerapp.rest;

import com.example.benitkibabu.randombeerapp.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by d12si on 23/05/2017.
 */

public class ApiClient{

   public static Retrofit getRetrofit(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://api.brewerydb.com/v2/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       return retrofit;
   }
}
