package com.example.spacexlaunches

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.spacexlaunches.data.Rockets
import com.example.spacexlaunches.net.RocketsRepo
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class RocketsViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var data: RocketsRepo

    @MockK
    lateinit var disposable: CompositeDisposable

    @MockK
    lateinit var context: Context

    lateinit var rocketsViewModel: RocketsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        rocketsViewModel = RocketsViewModel(data, disposable)
        every { disposable.add(any()) } returns (true)
    }


    @Test
    fun getData() {

        val listOfRockets = listOf(
            Rockets(
                false,
                0,
                "dummyCompany1",
                1,
                "UK",
                "Dummy description",
                null,
                null,
                "dummy id",
                "dummy name 1",
                "dummy type 1"
            ),
            Rockets(
                false,
                0,
                "dummyCompany 2",
                1,
                "UK",
                "Dummy description",
                null,
                null,
                "dummy id",
                "dummy name 2",
                "dummy type 2"
            )
        )

        every { data.getRocketData() } returns (Single.just(listOfRockets))

        rocketsViewModel.getData()

        Assert.assertEquals(listOfRockets, rocketsViewModel.rocketsRepoObservable.value)
    }
}