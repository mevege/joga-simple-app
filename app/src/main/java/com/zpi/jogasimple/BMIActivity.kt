package com.zpi.jogasimple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmiactivity.*
import kotlinx.android.synthetic.main.activity_main.*

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        result.text = ""
        info.text = ""

        btn.setOnClickListener {
            val h = (height.text).toString().toFloat() / 100
            val w = weight.text.toString().toFloat()
            val res = w / (h * h)
            result.text = "%.2f".format(res)

            if (res > 25) {
                info.text = "otyłość"
            } else if (res >= 19 && res < 24.99) {
                info.text = "waga prawidłowa"
            } else {
                info.text = "niedowaga"
            }
        }
    }
}




