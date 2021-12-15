package com.example.intentexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var nameEt: EditText
    lateinit var ageEt: EditText
    lateinit var enterBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        enterBtn.setOnClickListener {
            //Get the values from Layout & store them in variables
            val name: String = nameEt.text.toString()
            val age: Int = ageEt.text.toString().toInt()

            //Explicit Intent : Intents which supply either the
            // target app's package name or class name

            //Prepare the Intent
            val goToWelcomeIntent = Intent(this,WelcomeActivity::class.java)

            //Passing some extra data along with the intent
            goToWelcomeIntent.putExtra("name",name)
            goToWelcomeIntent.putExtra("age",age)

            //Start the new activity
            startActivity(goToWelcomeIntent)
        }

    }

    private fun initViews() {
        nameEt = findViewById(R.id.name_et)
        ageEt = findViewById(R.id.age_et)
        enterBtn = findViewById(R.id.enter_btn)
    }
}