package com.example.spacexlaunches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacexlaunches.net.RocketsRepo
import io.reactivex.disposables.CompositeDisposable
import java.lang.IllegalArgumentException

class RocketsViewModelFactory(
    private val data: RocketsRepo,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RocketsViewModel::class.java)) {
            return RocketsViewModel(data, compositeDisposable) as T
        }
        throw IllegalArgumentException("Unsupported Class")
    }
}