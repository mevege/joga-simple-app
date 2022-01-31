package com.zpi.jogasimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class setBeginners : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_beginners)

        exerciseBegButton.setOnClickListener{
            val dayBeginnersIntent = Intent(this,ExcerciseActivity::class.java)
            dayBeginnersIntent.putExtra("ExerciseSet", "excerciseMorning")
            startActivity(dayBeginnersIntent)
        }
        exerciseAdvButton.setOnClickListener{
            val nightBeginnersIntent = Intent(this,ExcerciseActivity::class.java)
            nightBeginnersIntent.putExtra("ExerciseSet", "excerciseNight")
            startActivity(nightBeginnersIntent)
        }

    }
}