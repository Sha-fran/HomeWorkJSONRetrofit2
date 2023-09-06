package com.example.homeworkjsonretrofit2

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : Activity() {
    private lateinit var textContent: TextView
    private lateinit var requestButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textContent = findViewById(R.id.textContent)
        requestButton = findViewById(R.id.requestButton)

        requestButton.setOnClickListener {
            val client = ApiClient.retrofit.create(ApiInterface::class.java)
            client.getCurrentWeather().enqueue(object :Callback<CurrentWeatherResponce> {
                override fun onResponse(
                    call: Call<CurrentWeatherResponce>,
                    response: Response<CurrentWeatherResponce>
                ) {
                    if (response.isSuccessful) {
                        val currentWeather = response.body()?.currentWeather
                        val message = "-Temperature: ${currentWeather?.temperature} \n- Wind direction: ${currentWeather?.winddirection}\n- Wind speed: ${currentWeather?.windspeed}"
                        textContent.text = message
                    }
                }

                override fun onFailure(call: Call<CurrentWeatherResponce>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG)
                }

            })
        }
    }
}
