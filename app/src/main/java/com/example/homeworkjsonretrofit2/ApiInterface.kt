package com.example.homeworkjsonretrofit2

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v1/forecast?latitude=50.4547&longitude=30.5238&current_weather=true")
    fun getCurrentWeather():Call<CurrentWeatherResponce>

    @GET("/v1/forecast?latitude=50.4547&longitude=30.5238&current_weather=true")
    fun getCurrentWeatherRx():Single<CurrentWeatherResponce>
}
