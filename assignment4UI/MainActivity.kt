package com.example.internetconnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Button
import android.widget.Toast
import com.example.internetconnection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var Binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        Binding.buttonCheck.setOnClickListener {
            if(checkForInternet(this))
            {
                Toast.makeText(this,"Connected",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Not Connected",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun checkForInternet(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }

        }else {

            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
             }

        }
}