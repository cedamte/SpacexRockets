package com.example.spacexlaunches.di

import com.example.spacexlaunches.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, NetworkModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}