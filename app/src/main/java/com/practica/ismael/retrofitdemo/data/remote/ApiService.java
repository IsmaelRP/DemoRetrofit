package com.practica.ismael.retrofitdemo.data.remote;

import android.app.DownloadManager;
import android.content.Context;

import com.practica.ismael.retrofitdemo.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService instance;
    private Api api;

    public static ApiService newInstance() {
        if(instance == null)
            instance = new ApiService();
        return instance;
    }

    private ApiService(){
        buildApService();
    }

    private void buildApService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public Api getApi(){
        return api;
    }
}
