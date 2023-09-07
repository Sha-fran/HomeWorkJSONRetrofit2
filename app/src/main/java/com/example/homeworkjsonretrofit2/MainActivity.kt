package com.example.homeworkjsonretrofit2

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : Activity() {
    private lateinit var textContent: TextView
    private lateinit var requestButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textContent = findViewById(R.id.textContent)
        requestButton = findViewById(R.id.requestButton)

        requestButton.setOnClickListener {
            textContent.text = ""

            val client = ApiClient.retrofit.create(ApiInterface::class.java)

            client.getCurrentWeatherRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result ->
                    textContent.text = "-Temperature: ${result.currentWeather?.temperature} \n" +
                            "- Wind direction: ${result.currentWeather?.winddirection}\n" +
                            "- Wind speed: ${result.currentWeather?.windspeed}"
                },
                {error ->
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG)
                })

        }
    }
}
