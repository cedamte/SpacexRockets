package com.example.spacexlaunches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacexlaunches.data.Rockets
import com.example.spacexlaunches.net.RocketsRepo
import io.reactivex.disposables.CompositeDisposable

class RocketsViewModel : ViewModel() {

    private val data: RocketsRepo = RocketsRepo()
    private val compositeDisposable= CompositeDisposable()
    val rocketsRepoObservable: MutableLiveData<List<Rockets>> = MutableLiveData()


    fun getData() {
        compositeDisposable.add(
            data.getRocketData()
                .subscribe { listOfRockets ->
                    rocketsRepoObservable.value = listOfRockets
                }
        )
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}