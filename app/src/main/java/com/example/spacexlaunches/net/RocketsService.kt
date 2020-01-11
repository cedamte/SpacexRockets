package com.example.spacexlaunches.net

import com.example.spacexlaunches.BuildConfig.ROCKETS_ENDPOINT
import com.example.spacexlaunches.data.Rockets
import io.reactivex.Single
import retrofit2.http.GET

interface RocketsService {
    @GET(ROCKETS_ENDPOINT)
    fun getRocketsData(): Single<List<Rockets>>
}