package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputButton = findViewById<Button>(R.id.input_button)
        inputButton.setOnClickListener(){
            callJson()
        }
    }

    fun callJson() {
        val postCode = textPostCodeInput.text

        val url =
            "https://api.weatherbit.io/v2.0/current?postal_code=${postCode}&key=30de3bdbeba044ed8eec5ae248945ba2"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("WrongViewCast")
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val weather = gson.fromJson(body, Weather::class.java)
                println(weather.data[0].city_name)
                runOnUiThread {
                    findViewById<TextView>(R.id.api_display)
                    api_display.text = weather.data[0].temp.toString()
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Nah, homie.")
            }
        })
    }

}

data class Weather(
    val data: List<Datum>,
    val count: Long
)

data class Datum(
    val rh: Long,
    val pod: String,
    val lon: Double,
    val pres: Float,
    val timezone: String,
    val obTime: String,
    val country_code: String,
    val clouds: Long,
    val ts: Long,
    val solarRAD: Double,
    val stateCode: String,
    val city_name: String,
    val windSpd: Double,
    val windCdirFull: String,
    val windCdir: String,
    val slp: Double,
    val vis: Long,
    val hAngle: Long,
    val sunset: String,
    val dni: Double,
    val dewpt: Double,
    val snow: Long,
    val uv: Double,
    val precip: Float,
    val windDir: Long,
    val sunrise: String,
    val ghi: Double,
    val dhi: Double,
    val aqi: Long,
    val lat: Double,
    val weather: WeatherClass,
    val datetime: String,
    val temp: Double,
    val station: String,
    val elevAngle: Double,
    val appTemp: Double
)

data class WeatherClass(
    val icon: String,
    val code: Long,
    val description: String
)

