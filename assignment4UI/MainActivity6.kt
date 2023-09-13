package com.example.assignment4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.widget.Button
import android.widget.TextView

//create an application to hide TextView when first button click and show
//when second button click
class MainActivity6 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var button1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        textView = findViewById(R.id.text1)
        button = findViewById(R.id.but1)
        button1 = findViewById(R.id.but2)


        button.setOnClickListener {

            textView.visibility = View.GONE
        }
        button1.setOnClickListener {
            textView.visibility =View.VISIBLE
        }
    }
}

