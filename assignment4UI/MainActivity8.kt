package com.example.assignment4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


//Create an application to input 2 numbers from user and all numbers
//between those 2 numbers in next activity
class MainActivity8 : AppCompatActivity() {


   private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        textView=findViewById(R.id.text_view)
        val intent = intent
        val str = intent.getStringExtra("Message")
        textView.text = str
    }
}