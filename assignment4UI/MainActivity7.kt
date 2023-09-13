package com.example.assignment4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


//Create an application to input 2 numbers from user and all numbers
//between those 2 numbers in next activity
class MainActivity7 : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)


        editText= findViewById(R.id.num1)
        editText2 = findViewById(R.id.num2)
        button = findViewById(R.id.button)


        button.setOnClickListener {

            val e1= editText.text.toString().toInt()
            val e2= editText2.text.toString().toInt()

            val sbf = StringBuilder()

            if(e1<=e2)
            {
                for(i in e1..e2)
                {
                    sbf.append("$i\n")
                }
            }
            if(e1>=e2)
            {
                for(j in e1 downTo e2)
                {
                    sbf.append("$j\n")
                 }

            }

            val intent = Intent(this, MainActivity8::class.java)
            intent.putExtra("Message",sbf.toString())
            startActivity(intent)

            editText.text.clear()
            editText2.text.clear()

            /*for(i in e1..e2)
            {
                sbf.append(i)
            }
            val intent = Intent(this, MainActivity8::class.java)
            intent.putExtra("Message",sbf.toString())
            startActivity(intent)*/
        }
    }
}
