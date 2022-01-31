package com.zpi.jogasimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class setAdvanced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_advanced)

        exerciseBegButton.setOnClickListener{
            val dayAdvancedIntent  = Intent(this,ExcerciseAdvancedActivity::class.java)
            dayAdvancedIntent.putExtra("ExerciseSet", "excerciseMorning")
            startActivity(dayAdvancedIntent)
        }
        exerciseAdvButton.setOnClickListener{
            val nightAdvancedIntent = Intent(this,ExcerciseAdvancedActivity::class.java)
            nightAdvancedIntent.putExtra("ExerciseSet", "excerciseNight")
            startActivity(nightAdvancedIntent)
        }

    }
}