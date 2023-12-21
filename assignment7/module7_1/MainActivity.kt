package com.example.assignment7

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    lateinit var button: Button
    lateinit var button2:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnPlayAudio)

        val ring: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.animalranbir)

        button.setOnClickListener {



            ring.start()


        }

        button2 = findViewById(R.id.btnPauseAudio)


        button2.setOnClickListener {

            ring.pause()


        }
    }
}