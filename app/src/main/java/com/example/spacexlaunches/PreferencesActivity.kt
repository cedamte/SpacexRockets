package com.example.spacexlaunches

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class PreferencesActivity : AppCompatActivity() {

    companion object {
        const val PREF_SHOW_ACTIVE: String = "PREF_SHOW_ACTIVE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences)
        title = "SpaceXLaunches settings"

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.preferences_container, PrefFragment())
        ft.commit()
    }

    class PrefFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.userpreferences, null)
        }

    }
}
