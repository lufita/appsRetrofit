package com.example.d2a.aplikasiretro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.8.50/slimuang/";

    public static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;
    }

}
