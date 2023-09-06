package com.example.homeworkjsonretrofit2

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponce(@SerializedName("current_weather") val currentWeather : CurrentWeather )

data class CurrentWeather (
    val temperature : String,
    val windspeed : String,
    val winddirection : String,
    val weathercode : String,
    val isDay : String,
    val time : String
)
