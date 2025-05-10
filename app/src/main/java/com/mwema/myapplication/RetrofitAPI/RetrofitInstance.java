package com.mwema.myapplication.RetrofitAPI;

import android.util.Log;

import com.mwema.myapplication.Models.Articles;
import com.mwema.myapplication.Models.NewsApiResponseModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private final static String apiKey = "YOUR_APIKEY";
    static Retrofit retrofit = null;
    static String TAG = "something";

    public static Retrofit get() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static List<Articles> getTopHeadlines(String country) {
        retrofit = RetrofitInstance.get();
        NewsAPI service = retrofit.create(NewsAPI.class);
        Call<NewsApiResponseModel> NewsResponse = service.getNews(country, apiKey);
        try {
            Response<NewsApiResponseModel> answer = NewsResponse.execute();
            if (answer.isSuccessful() && answer.body() != null) {
                return  answer.body().getArticlesList();
            }else{
                Log.e(TAG,"Body null or request unsuccessful");
            }
        } catch (IOException | RuntimeException e) {
            Log.e(TAG, "ERROR",e);
        }
        return null;
    }

}
