package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

//Create an application to display Textview when checkbox is checked and
//hide otherwise A6 Write a program to show four images around Textview.
class MainActivity4 : AppCompatActivity() {


    lateinit var checkBox: CheckBox
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        textView = findViewById(R.id.text1)
        checkBox = findViewById(R.id.chk1)



        checkBox.setOnClickListener {
            if(checkBox.isChecked)
            {
                    textView.setVisibility(View.VISIBLE)

            }
            else
            {
                textView.setVisibility(View.GONE)
            }

        }
    }
}

