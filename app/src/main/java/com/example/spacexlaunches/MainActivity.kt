package com.example.spacexlaunches

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexlaunches.data.Rockets

class MainActivity : AppCompatActivity() {

    companion object {
        const val MENU_PREFERENCES = Menu.FIRST + 1
        private const val SHOW_PREFERENCES = 1
    }


    private val mRockets = mutableListOf<Rockets>()
    private val mRocketsAdapter = RocketsAdapter(mRockets)
    private var mShowActive: Boolean = false
    lateinit var viewModel: RocketsViewModel

    private val mPrefListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (PreferencesActivity.PREF_SHOW_ACTIVE == key) {
                val rockets = viewModel.rocketsRepoObservable
                    .value

                if (rockets != null)
                    setRockets(rockets)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_rocket_list)



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = mRocketsAdapter


        viewModel = ViewModelProviders.of(this)
            .get(RocketsViewModel::class.java)

        viewModel.getData()


        viewModel.rocketsRepoObservable
            .observe(this, Observer { rockets ->
                //                rocketsAdapter.setData(rockets)
                setRockets(rockets)
            })


        // Register an OnSharedPreferenceChangeListener
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(baseContext)
        prefs.registerOnSharedPreferenceChangeListener(mPrefListener)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId) {
            MENU_PREFERENCES -> {
                val intent = Intent(this, PreferencesActivity::class.java)
                startActivityForResult(intent, SHOW_PREFERENCES)
                return true
            }
        }

        return false
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu?.add(0, MENU_PREFERENCES, Menu.NONE, R.string.menu_setting)
        return true
    }


    private fun setRockets(rockets: List<Rockets>) {
        updatePreferences()



        for (rocket in rockets) {
            if (!mRockets.contains(rocket)) {
                mRockets.add(rocket)
                mRocketsAdapter.notifyItemInserted(
                    mRockets.indexOf(rocket)
                )
            }
        }


        if (mRockets.size > 0) {
            for (i in mRockets.indices.reversed()) {
                if (mShowActive && mRockets[i].active != mShowActive) {
                    mRockets.removeAt(i)
                    mRocketsAdapter.notifyItemRemoved(i)
                }
            }
        }
    }

    private fun updatePreferences() {

        val prefs = PreferenceManager
            .getDefaultSharedPreferences(baseContext)


        mShowActive = prefs
            .getBoolean(PreferencesActivity.PREF_SHOW_ACTIVE, false)
    }
}
