package com.example.clinto.retrofit_sample2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Clinto on 22-Aug-17.
 */

public interface IGetNewsEvents {
    @GET("api/news_events/list?format=json")
    Call<ArrayList<NewsItem>> getNewsItems();
}
