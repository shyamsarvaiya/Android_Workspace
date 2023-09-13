package com.example.uiassignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
//program1
//Create an application to take input number from user and print its reverse
//number in TextView without button.
class MainActivity1 : AppCompatActivity() {


    private lateinit var edit2: EditText
    private lateinit var charCountMap: HashMap<Char, Int>
    private lateinit var show: TextView
    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        edit2=findViewById(R.id.edit2)
        charCountMap = HashMap()
        show=findViewById(R.id.show)
        save=findViewById(R.id.bt1)

        save.setOnClickListener {
            if(!edit2.text.toString().isEmpty()){
                val s = StringBuffer(edit2.text.toString())
                show.text=s.reverse()
                Toast.makeText(this,"Reverse String",Toast.LENGTH_LONG).show()
            }else{
                edit2.error="Please Enter Details:"
            }
        }
    }
}