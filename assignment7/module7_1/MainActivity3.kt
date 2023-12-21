package com.example.assignment7
//wifi on-off


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.wifi.WifiManager
import android.os.Build
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi


class MainActivity3 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btn = findViewById<Button>(R.id.wifiSwitch)
        val textView = findViewById<TextView>(R.id.tv)


        val wifi = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager

        btn.setOnClickListener {
            wifi.isWifiEnabled = !wifi.isWifiEnabled
            if (!wifi.isWifiEnabled) {
                textView.text = "Wifi is OFF"
            } else {
                textView.text = "Wifi is ON"
            }
        }
    }
}
