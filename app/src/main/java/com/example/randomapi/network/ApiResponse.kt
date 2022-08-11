package com.example.randomapi.network


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("info")
    val info: Info = Info(),
    @SerialName("results")
    val results: List<Result> = listOf()
)