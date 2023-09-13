package com.example.uiassignment4

//program-2
//Create an application to input 2 numbers from user and all numbers
//between those 2 numbers in next activity
//display view2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {


    lateinit var number1: EditText
    lateinit var number2: EditText
    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        button1 = findViewById(R.id.button1)

        button1.setOnClickListener {

            val i = Intent(this, display_view2::class.java)
            val uno =number1.text.toString()
            val uno1 = number2.text.toString()
            intent.putExtra("number1",uno)
            intent.putExtra("number2",uno1)
            startActivity(i)

        }
    }
}