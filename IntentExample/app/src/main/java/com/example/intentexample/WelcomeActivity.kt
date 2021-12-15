package com.example.intentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.net.Uri

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcomeTxt: TextView
    private lateinit var getDirectionsBtn: Button

    private val destinationLatitude = 21.2618911
    private val destinationLongitude = 81.549033

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        initViews()

        val receivedIntent = getIntent()

        //Get the data received along with Intent & store them in variables
        val name : String? = receivedIntent.getStringExtra("name")
        val age : Int = receivedIntent.getIntExtra("age",0)

        //Use the data any way you want
        welcomeTxt.text = "Hey $name ($age Yrs)\nYou are invited to the party !!"


        getDirectionsBtn.setOnClickListener {
            //Implicit Intent : Intents which declare a general action to perform,
            // which allows a component from another app to handle it

            //Prepare the Intent
            val directionsIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=$destinationLatitude,$destinationLongitude")
            )

            //Start the new activity
            startActivity(directionsIntent)
        }
    }

    private fun initViews() {
        welcomeTxt = findViewById(R.id.welcome_txt)
        getDirectionsBtn = findViewById(R.id.get_directions_btn)
    }

}