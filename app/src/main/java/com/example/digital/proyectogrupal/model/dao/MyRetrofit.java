package com.example.digital.proyectogrupal.model.dao;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    protected Retrofit retrofit;

    public MyRetrofit(String baseUrl) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.client(okHttpClient.build()).build();
    }
}
