package com.health.test.mvvm.koin.api

import com.health.test.mvvm.koin.model.TestDataResponse
import com.health.test.mvvm.koin.model.weather.WeatherApiResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApis {
    @GET("/api/users/2")
    fun getDataFromServer(): Single<TestDataResponse>

    @GET("/data/2.5/forecast?")
    fun getWeatherData(@Query("lat") lat: String?, @Query("lon") lon: String?, @Query("appid") appId: String?): Single<WeatherApiResponse>
}