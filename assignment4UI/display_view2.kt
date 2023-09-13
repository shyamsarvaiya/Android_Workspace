package com.example.uiassignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
//program-2
//Create an application to input 2 numbers from user and all numbers
//between those 2 numbers in next activity

class display_view2 : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var list:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_view2)


        listView = findViewById(R.id.list)
        list = ArrayList()


    }
}