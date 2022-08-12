package com.example.randomapi.network

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://randomuser.me/api/?results=2"

interface RandomApiService{
    @GET(BASE_URL)
    suspend fun getApiResponse(): ApiResponse
}
