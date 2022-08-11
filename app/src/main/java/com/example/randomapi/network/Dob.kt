package com.example.randomapi.network


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dob(
    @SerialName("age")
    val age: Int = 0,
    @SerialName("date")
    val date: String = ""
)