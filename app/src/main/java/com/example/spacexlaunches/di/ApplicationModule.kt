package com.example.spacexlaunches.di

import android.app.Application
import com.example.spacexlaunches.RocketsViewModelFactory
import com.example.spacexlaunches.net.RocketsRepo
import com.example.spacexlaunches.net.RocketsService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext() = application


    @Provides
    @Singleton
    fun provideRocketsRepo(rocketsService: RocketsService): RocketsRepo {
        return RocketsRepo(rocketsService)
    }

    @Provides
    @Singleton
    fun provideRocketsViewModelFactory(data: RocketsRepo): RocketsViewModelFactory {
        return RocketsViewModelFactory(data, CompositeDisposable())
    }
}