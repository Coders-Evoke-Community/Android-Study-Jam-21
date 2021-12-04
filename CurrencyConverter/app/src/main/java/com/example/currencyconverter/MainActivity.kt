package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    // EditText Views
    lateinit var rupeesEditText: EditText
    lateinit var dollarEditText: EditText

    // Arrow Views
    lateinit var rupeeToDollarImageView: ImageView
    lateinit var dollarToRupeeImageView: ImageView

    // Lottie Views
    lateinit var rupeeCoinLottieAnimation: LottieAnimationView
    lateinit var dollarCoinLottieAnimation: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        rupeeToDollarImageView.setOnClickListener {
            // Get Rupee value and pass it to the function
            val rupee = rupeesEditText.text.toString().toDouble()
            val dollarValue = convertRupeeToDollar(rupee).roundTo(2)

            // Set the value
            dollarEditText.text = dollarValue.toString().toEditable()

            // start Animation
            dollarCoinLottieAnimation.playAnimation()
        }

        dollarToRupeeImageView.setOnClickListener {
            // Get Dollar value and pass it to the function
            val dollar = dollarEditText.text.toString().toDouble()
            val convertedRupeeValue = convertDollarToRupee(dollar).roundTo(2)

            // Set the value
            rupeesEditText.text = convertedRupeeValue.toString().toEditable()

            // Start the Animation
            rupeeCoinLottieAnimation.playAnimation()
        }
    }

    private fun convertDollarToRupee(dollarValue: Double) = dollarValue * 75.24

    private fun convertRupeeToDollar(RupeeValue: Double) = RupeeValue / 75.24

    private fun initView() {
        // ET
        rupeesEditText = findViewById(R.id.inr_et)
        dollarEditText = findViewById(R.id.usd_et)

        // IV
        dollarToRupeeImageView = findViewById(R.id.usd_to_inr_btn)
        rupeeToDollarImageView = findViewById(R.id.inr_to_usd_btn)

        // Lottie View
        rupeeCoinLottieAnimation = findViewById(R.id.inr_coin)
        dollarCoinLottieAnimation = findViewById(R.id.usd_coin)
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun Double.roundTo(n: Int): Double {
        return "%.${n}f".format(this).toDouble()
    }

    private fun String.toUpperCase(): String {
        return this.uppercase()
    }
}