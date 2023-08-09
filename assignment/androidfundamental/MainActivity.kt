    package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

    class MainActivity : AppCompatActivity() {

    lateinit var bt:Button
    lateinit var ed:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt=findViewById(R.id.b1)
        ed = findViewById(R.id.e1)


        bt.setOnClickListener {

            val str=ed.text.toString()

            var i=Intent(applicationContext,background_color::class.java)
            i.putExtra("message_key",str)
            startActivity(i)

        }

    }
}