package com.example.randomapi.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    val name: String,
    val surname: String,
    val picture: String,
    val address: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
