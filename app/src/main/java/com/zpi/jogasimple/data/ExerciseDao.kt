package com.zpi.jogasimple.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
abstract class ExerciseDao {

    @Insert
    abstract fun addExercise(exercise: Exercise)

    @Query ("SELECT * FROM exercise_table")
    abstract fun getAllExercise() : List<Exercise>

    @Query ("SELECT * FROM exercise_table WHERE `set` LIKE 'morning' AND `type` LIKE 'beginner'")
    abstract fun getBegMorning() : List<Exercise>

    @Query ("SELECT * FROM exercise_table WHERE `set` LIKE 'morning' AND `type` LIKE 'advanced'")
    abstract fun getAdvMorning() : List<Exercise>

    @Query ("SELECT * FROM exercise_table WHERE `set` LIKE 'night' AND `type` LIKE 'beginner'")
    abstract fun getBegNight() : List<Exercise>

    @Query ("SELECT * FROM exercise_table WHERE `set` LIKE 'night' AND `type` LIKE 'advanced'")
    abstract fun getAdvNight() : List<Exercise>
//
//    @Query ("DELETE FROM exercise_table")
//    abstract fun deleteAll()

//    @Delete
//    abstract fun deleteAllExercise(exercise: Exercise)

    @Insert
    abstract fun addMultipleExercise(exercise: List<Exercise>)


}