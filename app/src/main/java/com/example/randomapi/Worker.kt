package com.example.randomapi

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.randomapi.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class Worker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    companion object {

        fun run(context: Context) {
            PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS
            val work = PeriodicWorkRequestBuilder<Worker>(repeatInterval = 5, TimeUnit.SECONDS).build()
            WorkManager.getInstance(context).enqueue(work)

        }
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        return@withContext try {
            val result = AppComponent.retrofit.getApiResponse()
            val newUsers = result.results.map { User( it.name.first, it.name.last, it.picture.medium, it.location.city) }
            AppComponent.userDatabase.userDao().addUsers(newUsers)
            Log.d("ihor", newUsers.toString())
            Result.success()
        } catch (error: Throwable){
            Result.failure()
        }
    }

}