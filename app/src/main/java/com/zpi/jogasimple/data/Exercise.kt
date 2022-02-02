package com.zpi.jogasimple.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exercise_table")
data class Exercise(
    val resource: Int,
    val description: String,
    val time: Int,
    val type: String,
    val set: String,
    ){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}