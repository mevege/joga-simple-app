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

//        private class WordDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : RoomDatabase.Callback() {
//            /**
//             * Override the onCreate method to populate the database.
//             */
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                // If you want to keep the data through app restarts,
//                // comment out the following line.
//                INSTANCE?.let { database ->
//                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.wordDao())
//                    }
//                }
//            }
//        }

    abstract fun exerciseDao(): ExerciseDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: ExerciseDatabase? = null

        fun getInstance(context: Context): ExerciseDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ExerciseDatabase {
            return Room.databaseBuilder(context, ExerciseDatabase::class.java, "exerciseBase")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                populateDatabase(it.exerciseDao())
                            }
                        }
                    }
                })
                .allowMainThreadQueries().build()


        }


        fun populateDatabase(exerciseDao: ExerciseDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.

//            exerciseDao.deleteAll()
            println(ExerciseDatabase)

            //BEGINNER - MORNING
            var newExercise = Exercise(R.drawable.beg_m_1,"lalala",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_2,"lalala",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_3,"lalala",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_4,"lalala",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_5,"lalala",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            //BEGINNER - NIGHT

            newExercise = Exercise(R.drawable.beg_n_1,"lalala",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_2,"lalala",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_3,"lalala",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_4,"lalala",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_5,"lalala",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            //ADVANCED - MORNING
            newExercise = Exercise(R.drawable.adv_m_1,"lalala",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_2,"lalala",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_3,"lalala",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_4,"lalala",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_5,"lalala",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            //ADVANCED - NIGHT
            newExercise = Exercise(R.drawable.adv_n_1,"lalala",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_2,"lalala",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_3,"lalala",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_4,"lalala",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_5,"lalala",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

//        }
        }
    }}

///*
// * Copyright (C) 2017 Google Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.example.android.roomwordssample
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
///**
// * This is the backend. The database. This used to be done by the OpenHelper.
// * The fact that this has very few comments emphasizes its coolness.
// */
//@Database(entities = [Word::class], version = 1)
//abstract class WordRoomDatabase : RoomDatabase() {
//
//    abstract fun wordDao(): WordDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: WordRoomDatabase? = null
//
//        fun getDatabase(
//            context: Context,
//            scope: CoroutineScope
//        ): WordRoomDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    WordRoomDatabase::class.java,
//                    "word_database"
//                )
//                    // Wipes and rebuilds instead of migrating if no Migration object.
//                    // Migration is not part of this codelab.
//                    .fallbackToDestructiveMigration()
//                    .addCallback(WordDatabaseCallback(scope))
//                    .build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//
//        private class WordDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : RoomDatabase.Callback() {
//            /**
//             * Override the onCreate method to populate the database.
//             */
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                // If you want to keep the data through app restarts,
//                // comment out the following line.
//                INSTANCE?.let { database ->
//                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.wordDao())
//                    }
//                }
//            }
//        }
//
//        /**
//         * Populate the database in a new coroutine.
//         * If you want to start with more words, just add them.
//         */
//        suspend fun populateDatabase(wordDao: WordDao) {
//            // Start the app with a clean database every time.
//            // Not needed if you only populate on creation.
//            wordDao.deleteAll()
//
//            var word = Word("Hello")
//            wordDao.insert(word)
//            word = Word("World!")
//            wordDao.insert(word)
//        }
//    }
//}