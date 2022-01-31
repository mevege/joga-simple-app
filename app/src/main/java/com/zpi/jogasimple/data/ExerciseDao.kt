package com.zpi.jogasimple.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
abstract class ExerciseDao {

    @Insert
    abstract fun addExercise(exercise: Exercise)

    @Query ("SELECT * FROM exercise_table")
    abstract fun getAllExercise() : List<Exercise>

    @Insert
    abstract fun addMultipleExercise(exercise: List<Exercise>)

}