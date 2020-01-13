package com.example.spacexlaunches.net

import com.example.spacexlaunches.data.Rockets
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RocketsRepo(private val rocketsService: RocketsService) {

    fun getRocketData(): Single<List<Rockets>> {
        return rocketsService.getRocketsData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}