package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.R.color.black


class background_color : AppCompatActivity() {
    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var text:TextView
  lateinit var relativeLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_color)
        // set button 1 with its id
        button1 = findViewById(R.id.bt1)

        // set button 2 with its id
        button2 = findViewById(R.id.bt2)
        button3 = findViewById(R.id.bt3)
        button4 = findViewById(R.id.bt4)
        text =findViewById(R.id.text1)


        // set relative layout with its id
        relativeLayout = findViewById(R.id.r1)


        val intent = intent
        val str =intent.getStringExtra("message_key")
        text.text =str

        button1.setOnClickListener{

            relativeLayout.setBackgroundResource(R.color.Button1)
        }
        // onClick function for button 1
    /*    button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                relativeLayout.setBackgroundResource(R.color.cool);
            }
        });

     */
        // onClick function for button 2
       button2.setOnClickListener{
           relativeLayout.setBackgroundResource(R.color.Button2)
       }
        button3.setOnClickListener {
            relativeLayout.setBackgroundResource(R.color.Button3)
        }
        button4.setOnClickListener {
            relativeLayout.setBackgroundResource(R.color.Button4)
        }
    }
}