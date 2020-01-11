package com.example.spacexlaunches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RocketsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_rocket_list)
        val rocketsAdapter = RocketsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rocketsAdapter


        viewModel = ViewModelProviders.of(this)
            .get(RocketsViewModel::class.java)

        viewModel.getData()


        viewModel.rocketsRepoObservable
            .observe(this, Observer { rocketsAdapter.setData(it) })
    }
}
