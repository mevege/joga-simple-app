package com.zpi.jogasimple

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.zpi.jogasimple.data.Exercise
import com.zpi.jogasimple.data.ExerciseDatabase
import kotlinx.android.synthetic.main.activity_excercise.*

class ExcerciseActivity : AppCompatActivity() {
    var exerciseTime = 30;
    var exerciseDescription = "Przykladowy opis"
    var exerciseImage = 0;
    var currentExcercise: Exercise? = null;
    var timerIsStarted = false
    var currentExcerciseNo = 0


    val db = ExerciseDatabase.getInstance(this)
    val ExerciseDao = db.exerciseDao()

    val exerciseMorning = ExerciseDao.getBegMorning()
    val exerciseNight = ExerciseDao.getBegNight()

    var currentExcerciseSet = exerciseMorning

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val setName = intent.extras?.get("ExerciseSet") as String
        val activityMain = findViewById(R.id.mainView) as ConstraintLayout
        val buttonStart = findViewById(R.id.startButton) as Button

        setName.let {
            if(it.contains("Morning")) {
                currentExcerciseSet = exerciseMorning
                activityMain.setBackgroundColor(Color.parseColor("#fffde8"));
            }
            else {
                currentExcerciseSet = exerciseNight
                activityMain.setBackgroundColor(Color.parseColor("#7799ff"));
                buttonStart.setBackgroundColor(Color.parseColor("#3355bb"))
            }
        }
        loadExercise(currentExcerciseSet[currentExcerciseNo])

        startButton.setOnClickListener{
            if(!timerIsStarted) {
                startExcercise()
            }
        }
    }

    fun loadExercise(exercise: Exercise){
        currentExcercise = exercise
        exerciseImage = exercise.resource
        exerciseTime = exercise.time
        exerciseDescription  = exercise.description

        var mediaPlayer = MediaPlayer.create(this, R.raw.bensound_relaxing)
        mediaPlayer.start()

        var underNineTxt = ""

        if (exerciseTime<10) {underNineTxt= "0"}
        timerView.setText("00:${underNineTxt}${exerciseTime}")

        imageView3.setImageResource(exerciseImage)
    }

    fun startExcercise(){
        val thread = Thread {
            var number = exerciseTime
            timerIsStarted = true

            for (i in 0..exerciseTime) {
                var underNineTxt = "";
                if (number<10) {underNineTxt= "0"}
                runOnUiThread {
                    timerView.setText("00:${underNineTxt}${number}")
                }
                Thread.sleep(1000)
                number--
            }

            runOnUiThread{

                var mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_bells_medium_bell_soft_strike_long_decay_002_60153)
                mediaPlayer.start()

                currentExcerciseNo++

                if(currentExcerciseNo >= currentExcerciseSet.size) {
                    val excerciseIntent4 = Intent(this,MainActivity::class.java)
                    startActivity(excerciseIntent4)
                    currentExcerciseNo = 0
                }
                else{
                    loadExercise(currentExcerciseSet[currentExcerciseNo])
                    openStartDialog()
                }
                }

            timerIsStarted = false
        }
        thread.start()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->finish()
            R.id.id_info->{
                openStartDialog()
                return true
            }
            R.id.id_sound->{
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun openStartDialog(){
        val dialogBuilder = AlertDialog.Builder(this)

        val dialogView = layoutInflater.inflate(R.layout.excercise_dialog_layout,null)

        val dialogExcerciseView = dialogView.findViewById(R.id.dialogExcerciseImageView) as ImageView
        dialogExcerciseView.setImageResource(exerciseImage)

        dialogBuilder.setMessage(currentExcercise?.description)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setPositiveButton("OK"){
                dialog, id ->
        }
        val dialog = dialogBuilder.create()

        if(currentExcerciseNo <= currentExcerciseSet.size -1) {
            dialog.show()
        }
    }
}