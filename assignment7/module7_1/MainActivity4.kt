@file:Suppress("DEPRECATION")
//Create an application to convert text typed in edit text into speech
package com.example.assignment7

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity4 : AppCompatActivity() {


  private lateinit var Text: EditText
    private lateinit  var btnText: Button
    private lateinit  var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        Text = findViewById(R.id.Text)
        btnText = findViewById(R.id.btnText)
        textToSpeech = TextToSpeech(
            applicationContext
        ) { i ->
            if (i != TextToSpeech.ERROR) {

                textToSpeech.language = Locale.ENGLISH
            }
        }


        btnText.setOnClickListener {
            textToSpeech.speak(
                Text.text.toString(), TextToSpeech.QUEUE_FLUSH, null
            )
        }
    }
}
