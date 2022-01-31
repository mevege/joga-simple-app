package com.zpi.jogasimple.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zpi.jogasimple.R
import java.util.concurrent.Executors
import com.zpi.jogasimple.data.ExerciseDao

@Database(entities = [Exercise::class], version = 2, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ExerciseDatabase? = null

        fun getInstance(context: Context): ExerciseDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ExerciseDatabase {
            return Room.databaseBuilder(context, ExerciseDatabase::class.java, "exercise_table")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                it.exerciseDao().addMultipleExercise(ExerciseAll.getAllExercise())
                            }
                        }
                    }
                })
                .allowMainThreadQueries().build()
        }
    }
}