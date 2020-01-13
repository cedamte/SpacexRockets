package com.example.spacexlaunches.net

import com.example.spacexlaunches.BuildConfig.BASE_URL
import com.example.spacexlaunches.data.Rockets
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RocketsRepo(private val rocketsService: RocketsService) {


//    init {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//
//        rocketsService = retrofit.create(
//            RocketsService::class.java
//        )
//    }

    fun getRocketData(): Single<List<Rockets>> {
        return rocketsService.getRocketsData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}