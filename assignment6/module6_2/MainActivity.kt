package com.example.googlemapmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}





































/*
    private lateinit var switchCompat:SwitchMaterial
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesEditor: SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchCompat = findViewById(R.id.swi1)

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val  nightmode = sharedPreferences.getBoolean("nightmode",false)

        if (nightmode)
        {
            switchCompat.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        switchCompat.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            if(nightmode)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferencesEditor = sharedPreferences.edit()
                sharedPreferencesEditor.putBoolean("nightmode",false)
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferencesEditor = sharedPreferences.edit()
                sharedPreferencesEditor.putBoolean("nightmode",true)

            }
            sharedPreferencesEditor.apply()


        })
    }*/
