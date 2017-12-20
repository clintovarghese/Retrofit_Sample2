package com.example.clinto.retrofit_sample2;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Clinto on 21-Aug-17.
 */

public class MyApplication extends Application {
   public static final String Base_url="http://iroidtech.com/wecare/";
    private static Retrofit retrofit=null;
    @Override
    public void onCreate(){
        super.onCreate();
    }
    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.MAIN_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;


    }

}

