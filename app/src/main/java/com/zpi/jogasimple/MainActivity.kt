package com.zpi.jogasimple

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.zpi.jogasimple.data.ExerciseDao
import com.zpi.jogasimple.data.ExerciseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = ExerciseDatabase.getInstance(this)

        val ExerciseDao = db.exerciseDao()
        val exercisesList = ExerciseDao.getAllExercise()
        println(exercisesList)




        exerciseBegButton.setOnClickListener{
            val setBeginnersIntent = Intent(this,setBeginners::class.java)
            startActivity(setBeginnersIntent)
        }
        exerciseAdvButton.setOnClickListener{
            val setAdvancedIntent = Intent(this,setAdvanced::class.java)
            startActivity(setAdvancedIntent)
        }
        calculatorsButton.setOnClickListener{
            val excerciseIntent4 = Intent(this,BMIActivity::class.java)
            startActivity(excerciseIntent4)
        }
        aboutButton.setOnClickListener{
            val excerciseIntent3 = Intent(this,aboutActivity::class.java)
            startActivity(excerciseIntent3)
        }
    }
}