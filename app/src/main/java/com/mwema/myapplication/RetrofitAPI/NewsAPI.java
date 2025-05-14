package com.mwema.myapplication.RetrofitAPI;


import androidx.annotation.NonNull;

import com.mwema.myapplication.Models.NewsApiResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("top-headlines")
    Call<NewsApiResponseModel> getNews(
            @Query("country") String countryCode,
            @Query("apiKey")String apiKey,
            @Query("q") String query
    );
}
