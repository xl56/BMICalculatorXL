package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CalcBtn.setOnClickListener()
        {
            val weight = weight.text.toString().toDouble()
            val height = editText2.text.toString().toDouble()

            val bmi = calculateBMI(height, weight)
            val status :String

            if(bmi <= 18.5) {
                status = "Under"
                imageView.setImageResource(R.drawable.under)
            }
            else if (bmi <= 24.9) {
                status = "Normal"
                imageView.setImageResource(R.drawable.normal)
            }
            else {
                status = "Over"
                imageView.setImageResource(R.drawable.over)
            }

            textView4.text = "BMI : %.2f (%s)".format(bmi, status)


        }

        ResetBtn.setOnClickListener {
            imageView.setImageResource(R.drawable.empty)
            textView4.text = null
            weight.text = null
            editText2.text = null

        }




    }
    fun calculateBMI(height:Double,weight:Double):Double{
        return height / (weight * weight)
    }



}
