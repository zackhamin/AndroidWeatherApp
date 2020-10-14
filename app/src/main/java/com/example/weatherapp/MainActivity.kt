package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            callJson()
    }

    fun callJson() {
        val apiKey = "30de3bdbeba044ed8eec5ae248945ba2"

        val url =
            "https://api.weatherbit.io/v2.0/forecast/daily?city=athens&country=gr&key=${apiKey}"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("WrongViewCast")
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val weather = gson.fromJson(body, Weather::class.java)
                println(weather.data)

                runOnUiThread {

                    weather_temp_text.text = weather.data[0].temp.toString() + "\u2103"
                    description_text_view.text = weather.data[0].weather.description
                    city_text.text = weather.city_name + "," + weather.country_code

                    day_one_text.text = "  " + weather.data[1].datetime.toString() + "      "
                    day_two_text.text = "  " + weather.data[2].datetime.toString() + "       "
                    day_three_text.text = "  " + weather.data[3].datetime.toString() + "       "
                    day_four_text.text = "  " + weather.data[4].datetime.toString() + "       "

                    day_one_temp.text = weather.data[1].temp.toString() + "\u2103       "
                    day_two_temp.text = weather.data[2].temp.toString() + "\u2103       "
                    day_three_temp.text = weather.data[3].temp.toString() + "\u2103     "
                    day_four_temp.text = weather.data[4].temp.toString() + "\u2103      "



                    when (weather.data[0].weather.code) {

//                        802 -> weather_image_view.setImageResource(R.drawable.darkcloudy)
//                        200 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        201 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        202 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        230 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        231 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        232 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//                        233 -> weather_image_view.setImageResource(R.drawable.thunderstorm)
//
//                        300 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        301 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        302 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        500 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        501 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        502 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        511 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        520 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        521 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        522 -> weather_image_view.setImageResource(R.drawable.rainy)
//                        900 -> weather_image_view.setImageResource(R.drawable.rainy)
//
                        800 -> background_image.setImageResource(R.drawable.sunnywallpaper)
//
                        801 -> background_image.setImageResource(R.drawable.sunnywallpaper)
                        802 -> background_image.setImageResource(R.drawable.sunnywallpaper)
//
                        803 -> background_image.setImageResource(R.drawable.cloudy_wallpaper)
                        804 -> background_image.setImageResource(R.drawable.cloudy_wallpaper)
                    }

                    when (weather.data[1].weather.code) {
                        802 -> image_weather_one.setImageResource(R.drawable.darkcloudy)
                        200 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        201 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        202 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        230 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        231 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        232 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        233 -> image_weather_one.setImageResource(R.drawable.thunderstorm)

                        300 -> image_weather_one.setImageResource(R.drawable.rainy)
                        301 -> image_weather_one.setImageResource(R.drawable.rainy)
                        302 -> image_weather_one.setImageResource(R.drawable.rainy)
                        500 -> image_weather_one.setImageResource(R.drawable.rainy)
                        501 -> image_weather_one.setImageResource(R.drawable.rainy)
                        502 -> image_weather_one.setImageResource(R.drawable.rainy)
                        511 -> image_weather_one.setImageResource(R.drawable.rainy)
                        520 -> image_weather_one.setImageResource(R.drawable.rainy)
                        521 -> image_weather_one.setImageResource(R.drawable.rainy)
                        522 -> image_weather_one.setImageResource(R.drawable.rainy)
                        900 -> image_weather_one.setImageResource(R.drawable.rainy)

                        800 -> image_weather_one.setImageResource(R.drawable.sunsout)

                        801 -> image_weather_one.setImageResource(R.drawable.suncloud_copy)
                        802 -> image_weather_one.setImageResource(R.drawable.sunsout)

                        803 -> image_weather_one.setImageResource(R.drawable.darkcloudy)
                        804 -> image_weather_one.setImageResource(R.drawable.darkcloudy)


                    }
                    when(weather.data[2].weather.code){
                        802 -> image_weather_two.setImageResource(R.drawable.darkcloudy)
                        200 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        201 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        202 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        230 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        231 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        232 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        233 -> image_weather_two.setImageResource(R.drawable.thunderstorm)

                        300 -> image_weather_two.setImageResource(R.drawable.rainy)
                        301 -> image_weather_two.setImageResource(R.drawable.rainy)
                        302 -> image_weather_two.setImageResource(R.drawable.rainy)
                        500 -> image_weather_two.setImageResource(R.drawable.rainy)
                        501 -> image_weather_two.setImageResource(R.drawable.rainy)
                        502 -> image_weather_two.setImageResource(R.drawable.rainy)
                        511 -> image_weather_two.setImageResource(R.drawable.rainy)
                        520 -> image_weather_two.setImageResource(R.drawable.rainy)
                        521 -> image_weather_two.setImageResource(R.drawable.rainy)
                        522 -> image_weather_two.setImageResource(R.drawable.rainy)
                        900 -> image_weather_two.setImageResource(R.drawable.rainy)

                        800 -> image_weather_two.setImageResource(R.drawable.sunsout)

                        801 -> image_weather_two.setImageResource(R.drawable.suncloud_copy)
                        802 -> image_weather_two.setImageResource(R.drawable.sunsout)

                        803 -> image_weather_two.setImageResource(R.drawable.darkcloudy)
                        804 -> image_weather_two.setImageResource(R.drawable.darkcloudy)


                    }

                    when(weather.data[3].weather.code){
                        802 -> image_weather_three.setImageResource(R.drawable.darkcloudy)
                        200 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        201 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        202 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        230 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        231 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        232 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        233 -> image_weather_three.setImageResource(R.drawable.thunderstorm)

                        300 -> image_weather_three.setImageResource(R.drawable.rainy)
                        301 -> image_weather_three.setImageResource(R.drawable.rainy)
                        302 -> image_weather_three.setImageResource(R.drawable.rainy)
                        500 -> image_weather_three.setImageResource(R.drawable.rainy)
                        501 -> image_weather_three.setImageResource(R.drawable.rainy)
                        502 -> image_weather_three.setImageResource(R.drawable.rainy)
                        511 -> image_weather_three.setImageResource(R.drawable.rainy)
                        520 -> image_weather_three.setImageResource(R.drawable.rainy)
                        521 -> image_weather_three.setImageResource(R.drawable.rainy)
                        522 -> image_weather_three.setImageResource(R.drawable.rainy)
                        900 -> image_weather_three.setImageResource(R.drawable.rainy)

                        800 -> image_weather_three.setImageResource(R.drawable.sunsout)

                        801 -> image_weather_three.setImageResource(R.drawable.suncloud_copy)
                        802 -> image_weather_three.setImageResource(R.drawable.sunsout)

                        803 -> image_weather_three.setImageResource(R.drawable.darkcloudy)
                        804 -> image_weather_three.setImageResource(R.drawable.darkcloudy)

                    }
                    when(weather.data[4].weather.code){
                        802 -> image_weather_four.setImageResource(R.drawable.darkcloudy)
                        200 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        201 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        202 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        230 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        231 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        232 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        233 -> image_weather_four.setImageResource(R.drawable.thunderstorm)

                        300 -> image_weather_four.setImageResource(R.drawable.rainy)
                        301 -> image_weather_four.setImageResource(R.drawable.rainy)
                        302 -> image_weather_four.setImageResource(R.drawable.rainy)
                        500 -> image_weather_four.setImageResource(R.drawable.rainy)
                        501 -> image_weather_four.setImageResource(R.drawable.rainy)
                        502 -> image_weather_four.setImageResource(R.drawable.rainy)
                        511 -> image_weather_four.setImageResource(R.drawable.rainy)
                        520 -> image_weather_four.setImageResource(R.drawable.rainy)
                        521 -> image_weather_four.setImageResource(R.drawable.rainy)
                        522 -> image_weather_four.setImageResource(R.drawable.rainy)
                        900 -> image_weather_four.setImageResource(R.drawable.rainy)

                        800 -> image_weather_four.setImageResource(R.drawable.sunsout)

                        801 -> image_weather_four.setImageResource(R.drawable.suncloud_copy)
                        802 -> image_weather_four.setImageResource(R.drawable.sunsout)

                        803 -> image_weather_four.setImageResource(R.drawable.darkcloudy)
                        804 -> image_weather_four.setImageResource(R.drawable.darkcloudy)


                    }

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
    val count: Long,
    val city_name: String,
    val country_code: String
)

data class Datum(
    val rh: Long,
    val pod: String,
    val lon: Double,
    val pres: Float,
    val timezone: String,
    val obTime: String,
    val clouds: Long,
    val ts: Long,
    val solarRAD: Double,
    val stateCode: String,
    val windSpd: Double,
    val windCdirFull: String,
    val windCdir: String,
    val slp: Double,
    val vis: Float,
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
    val code: Int,
    val description: String
)

