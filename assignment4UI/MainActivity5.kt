package com.example.assignment4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

//Create an application with radio buttons (Add, Subtraction, Multiply,
//Division) EditText (number1, number2) and print result as per user choice
//from radio button in TextView
class MainActivity5 : AppCompatActivity() {

    lateinit var edit:EditText
    lateinit var edit2:EditText
    lateinit var sum:RadioButton
    lateinit var sub:RadioButton
    lateinit var multi:RadioButton
    lateinit var div:RadioButton
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)



        edit=findViewById(R.id.num1)
        edit2 = findViewById(R.id.num2)
        sum = findViewById(R.id.sum)
        sub= findViewById(R.id.sub)
        multi= findViewById(R.id.multi)
        div= findViewById(R.id.div)



        sum.setOnClickListener {

            var e1=edit.text.toString().toInt()
            var e2=edit2.text.toString().toInt()
            var result = findViewById<TextView>(R.id.total)

            result.text= (e1+e2).toString()
        }
        sub.setOnClickListener {

            var e1=edit.text.toString().toInt()
            var e2=edit2.text.toString().toInt()
            var result = findViewById<TextView>(R.id.total)

            result.text= (e1-e2).toString()

        }
        multi.setOnClickListener {

            var e1=edit.text.toString().toInt()
            var e2=edit2.text.toString().toInt()
            var result = findViewById<TextView>(R.id.total)

            result.text= (e1*e2).toString()

        }
        div.setOnClickListener {
            var e1=edit.text.toString().toInt()
            var e2=edit2.text.toString().toInt()
            var result = findViewById<TextView>(R.id.total)

            result.text= (e1/e2).toString()
        }


    }
}