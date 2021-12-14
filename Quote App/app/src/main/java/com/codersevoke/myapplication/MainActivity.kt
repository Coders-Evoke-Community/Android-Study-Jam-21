package com.codersevoke.myapplication

import retrofit2.Callback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codersevoke.myapplication.databinding.ActivityMainBinding
import com.codersevoke.myapplication.model.QuoteResponse
import com.codersevoke.myapplication.network.Networking
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        mainBinding.nextQuoteBtn.setOnClickListener {
            val networkService = Networking.create().getQuotes()
            networkService.enqueue(object : Callback<QuoteResponse> {
                override fun onResponse(
                    call: Call<QuoteResponse>,
                    response: Response<QuoteResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        mainBinding.textView.text = response.body()!!.content
                    } else {
                        Toast.makeText(this@MainActivity, "Body is empty", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "No internet connections", Toast.LENGTH_SHORT)
                        .show()
                }

            })

        }
    }
}