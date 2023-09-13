package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.widget.TextView

// Write a program to show four images around Textview.
class MainActivity10 : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        textView = findViewById(R.id.textview)


        val ssb = SpannableStringBuilder()
        ssb.append("Hello")
        ssb.setSpan(ImageSpan(this,R.drawable.slide2),ssb.length-1,ssb.length,0)
        ssb.append("Android")
        ssb.setSpan(ImageSpan(this,R.drawable.slide3),ssb.length-1,ssb.length,0)
        ssb.append("Java")
        ssb.setSpan(ImageSpan(this,R.drawable.slide4),ssb.length-1,ssb.length,0)
        ssb.append("Kotlin")
        ssb.setSpan(ImageSpan(this,R.drawable.slide4),ssb.length-1,ssb.length,0)
        textView.text = ssb
    }
}