package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        val url = "https://api.weatherbit.io/v2.0/current?city=Manchester&country=GB&key=30de3bdbeba044ed8eec5ae248945ba2"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("WrongViewCast")
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)
                runOnUiThread {
                    findViewById<TextView>(R.id.api_display)
                    api_display.text = body
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Nah, homie.")
            }
        })
        }


    }
