package com.example.randomapi

import android.app.Application
import com.example.randomapi.data.UserDatabase
import com.example.randomapi.network.BASE_URL
import com.example.randomapi.network.RandomApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppComponent {

    lateinit var userDatabase: UserDatabase

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build().create(RandomApiService::class.java)
}

