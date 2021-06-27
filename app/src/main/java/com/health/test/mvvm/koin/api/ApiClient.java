package com.health.test.mvvm.koin.api;


import com.health.test.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {
    public static final String BASE_URL = BuildConfig.BASE_URL;
    private static Retrofit retrofit_image = null, retrofit = null, retrofitMvvm = null;
    ;
    public static int unique_id;


    public static Retrofit getClientMVVMBaseUrl() {

        if (retrofitMvvm == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(6 * 60, TimeUnit.SECONDS)
                    .readTimeout(2 * 60, TimeUnit.SECONDS).build();
            retrofitMvvm = new Retrofit.Builder()
                    .baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofitMvvm;
    }
}
