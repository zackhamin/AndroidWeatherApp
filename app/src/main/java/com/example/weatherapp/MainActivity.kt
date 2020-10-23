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
            "https://api.weatherbit.io/v2.0/forecast/daily?city=manchester&country=gb&key=${apiKey}"
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
                    day_two_text.text = "  " + weather.data[2].datetime.toString() + "      "
                    day_three_text.text = "  " + weather.data[3].datetime.toString() + "      "
                    day_four_text.text = "  " + weather.data[4].datetime.toString() + "      "
                    day_five_text.text = "  " + weather.data[5].datetime.toString() + "      "
                    day_six_text.text = "  " + weather.data[6].datetime.toString() + "      "
                    day_seven_text.text = "  " + weather.data[7].datetime.toString() + "      "

                    day_one_temp.text = weather.data[1].temp.toString() + "\u2103       "
                    day_two_temp.text = weather.data[2].temp.toString() + "\u2103       "
                    day_three_temp.text = weather.data[3].temp.toString() + "\u2103       "
                    day_four_temp.text = weather.data[4].temp.toString() + "\u2103       "
                    day_five_temp.text = weather.data[5].temp.toString() + "\u2103       "
                    day_six_temp.text = weather.data[6].temp.toString() + "\u2103       "
                    day_seven_temp.text = weather.data[7].temp.toString() + "\u2103       "



                    when (weather.data[0].weather.code) {
                        in 800..802 -> background_image.setImageResource(R.drawable.sunnywallpaper)
                        in 803..804 -> background_image.setImageResource(R.drawable.cloudy_wallpaper)
                        in 200..799 -> background_image.setImageResource(R.drawable.cloudy_wallpaper)
                    }

                    when (weather.data[1].weather.code) {

                        in 200..233 -> image_weather_one.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_one.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_one.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_one.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_one.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_one.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[2].weather.code) {
                        in 200..233 -> image_weather_two.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_two.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_two.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_two.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_two.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_two.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[3].weather.code) {
                        in 200..233 -> image_weather_three.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_three.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_three.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_three.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_three.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_three.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[4].weather.code) {
                        in 200..233 -> image_weather_four.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_four.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_four.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_four.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_four.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_four.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[5].weather.code) {
                        in 200..233 -> image_weather_five.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_five.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_five.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_five.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_five.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_five.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[6].weather.code) {
                        in 200..233 -> image_weather_six.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_six.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_six.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_six.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_six.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_six.setImageResource(R.drawable.rainy)
                    }
                    when (weather.data[7].weather.code) {
                        in 200..233 -> image_weather_seven.setImageResource(R.drawable.thunderstorm)
                        in 300..522 -> image_weather_seven.setImageResource(R.drawable.rainy)
                        in 802..804 -> image_weather_seven.setImageResource(R.drawable.darkcloudy)

                        800 -> image_weather_seven.setImageResource(R.drawable.sunsout)
                        801 -> image_weather_seven.setImageResource(R.drawable.suncloud_copy)
                        900 -> image_weather_seven.setImageResource(R.drawable.rainy)
                    }

                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("No API return")
            }


        })
    }

}


