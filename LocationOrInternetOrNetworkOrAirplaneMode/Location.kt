package com.example.locationgpsex

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var toneGenerator: ToneGenerator? = null
    private var timer: Timer? = null
    private var audioManager: AudioManager? = null
    private var locationManager: LocationManager? = null
    private var gpsDialog: AlertDialog? = null

    private lateinit var telephonyManager: TelephonyManager

    private lateinit var signalStrengthReceiver: BroadcastReceiver
    private lateinit var connectivityReceiver: ConnectivityReceiver
    private var handler: Handler? = null

    // private lateinit var telephonyManager: TelephonyManager
//   private lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        toneGenerator = ToneGenerator(AudioManager.STREAM_ALARM, ToneGenerator.MAX_VOLUME)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        //    wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        /*  telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager


          telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
  */

        handler = Handler(Looper.getMainLooper())

        if (!isLocationPermissionGranted) {
            requestLocationPermission()
        }

        /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
             if (ActivityCompat.checkSelfPermission(
                     this,
                     Manifest.permission.READ_PHONE_STATE
                 ) != PackageManager.PERMISSION_GRANTED
             ) {
                 ActivityCompat.requestPermissions(
                     this,
                     arrayOf(Manifest.permission.READ_PHONE_STATE),
                     PERMISSION_REQUEST_CODE
                 )
             } else {
                 startListening()
             }
         } else {
             startListening()
         }*/
        /*  if(!issimpermission)
          {
              requestsimpermission()
          }*/
        connectivityReceiver = ConnectivityReceiver()
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(connectivityReceiver, filter)

        startCheckingGPSStatus()
        checkNetworkStatus()
        startListening()
        //  startListening()

    }
    override fun onDestroy() {
        super.onDestroy()

        if (toneGenerator != null) {
            toneGenerator!!.release()
        }

        if (timer != null) {
            timer!!.cancel()
        }
        telephonyManager.listen(null, PhoneStateListener.LISTEN_NONE)
        unregisterReceiver(connectivityReceiver)


    }

    private val isLocationPermissionGranted: Boolean
        private get() = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.ACCESS_FINE_LOCATION),
            MainActivity.Companion.REQUEST_LOCATION_PERMISSION)
    }
    /*  private val isInternetPermissionGranted: Boolean
          private get() = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED


      private fun requestInternetPermission() {
          ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.ACCESS_NETWORK_STATE),
              MainActivity.Companion.REQUEST_INTERNET_PERMISSION)
      }*/



    /*  private val issimpermission:Boolean
          private get() = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED

      private fun requestsimpermission()
      {
          ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), 101)
      }*/

    private val isGPSEnabled: Boolean
        private get() = locationManager != null && locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)


    /*   private val isInternetConnected: Boolean
           private get() = connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected

   */


    /* private val isInternetConnected : Boolean
         private get() = connectivityManager.activeNetworkInfo  != null && connectivityManager.activeNetworkInfo!!.isConnected

 */
    /* private fun isAirplaneModeOn(): Boolean {
         return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
             Settings.Global.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0
         } else {
             Settings.System.getInt(contentResolver, Settings.System.AIRPLANE_MODE_ON, 0) != 0
         }
     }
 */


    private fun startCheckingGPSStatus() {
        timer = Timer()
        timer!!.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (!isGPSEnabled /*&& isAirplaneModeOn()*/) {
                    startToneGeneration()
                    showGPSDialog()
                } else {
                    stopToneGeneration()
                    dismissGPSDialog()
                }
            }
        }, 0, 1000)
    }
    private fun checkNetworkStatus() {
        handler!!.postDelayed({
            if (!isNetworkConnected()) {
                // Both Wi-Fi and mobile internet connections are lost
                startToneGeneration()
            } else {
                // At least one network connection is available
                stopToneGeneration()
            }
            // Schedule next check after 1 second
            checkNetworkStatus()
        }, 1000)
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                (networkCapabilities.hasTransport(android.net.NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(android.net.NetworkCapabilities.TRANSPORT_CELLULAR))
    }
    private fun isAirplaneModeOn(): Boolean {
        return Settings.Global.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0
    }
    inner class ConnectivityReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                // Airplane mode has changed
                if (isAirplaneModeOn()) {
                    // Stop beep sound when airplane mode is turned on
                    startToneGeneration()
                }
                else
                {
                    stopToneGeneration()
                }
            }
        }
    }
    private fun startListening() {
        signalStrengthReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == "android.intent.action.SIG_STR") {
                    val gsmSignalStrength = intent.getIntExtra("gsmSignalStrength", 4)

                    if (gsmSignalStrength < 2) {
                        startToneGeneration()

                    } else {
                        stopToneGeneration()
                    }
                }
            }
        }

        val filter = IntentFilter("android.intent.action.SIG_STR")
        registerReceiver(signalStrengthReceiver, filter)
    }

    /*  private fun startListening() {
          telephonyManager.listen(object : PhoneStateListener() {
              @RequiresApi(Build.VERSION_CODES.P)
              override fun onServiceStateChanged(serviceState: ServiceState) {
                  super.onServiceStateChanged(serviceState)

                  // Check the GSM signal strength for both SIM cards
                  val sim1SignalStrength = telephonyManager.signalStrength!!.gsmSignalStrength
                  val sim2SignalStrength = telephonyManager.signalStrength!!.gsmSignalStrength

                  // Check if either SIM card's signal strength is 0
                  if (sim1SignalStrength == 0 || sim2SignalStrength == 0) {
                      // If any one sim GSM signal is 0, start a beep sound
                      playBeep()
                  }
              }
          }, PhoneStateListener.LISTEN_SERVICE_STATE)
      }*/
    /*  telephonyManager.listen(object : PhoneStateListener() {
          @SuppressLint("MissingPermission")
          override fun onSignalStrengthsChanged(signalStrength: android.telephony.SignalStrength) {
              super.onSignalStrengthsChanged(signalStrength)

              // Check if the network type is 4G or 5G
              val networkType = telephonyManager.networkType
              if (networkType == TelephonyManager.NETWORK_TYPE_LTE || networkType == TelephonyManager.NETWORK_TYPE_NR) {
                  // Get signal strength for LTE/5G
                  val signalStrengthValue = signalStrength.level

                  // Assuming signal strength ranges from 0 to 4 (0 is weakest, 4 is strongest)
                  val threshold = 1

                  if (signalStrengthValue < threshold) {
                      // Signal strength is less than 1, play beep sound
                      playBeep()
                  }
              }
          }
      }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)*/
    /*  telephonyManager.listen(object : PhoneStateListener() {
          override fun onServiceStateChanged(serviceState: android.telephony.ServiceState) {
              super.onServiceStateChanged(serviceState)
              if (serviceState.state == android.telephony.ServiceState.STATE_OUT_OF_SERVICE) {
                  // Network signal lost, play beep sound
                  startToneGeneration()
                 // playBeep()
              }
          }
      }, PhoneStateListener.LISTEN_SERVICE_STATE)*/

    /* private fun playBeep() {
         audioManager!!.setStreamVolume(
             AudioManager.STREAM_ALARM,
             audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM),
             AudioManager.FLAG_PLAY_SOUND
         )

         if (toneGenerator != null) {
             toneGenerator!!.startTone(ToneGenerator.TONE_CDMA_PIP)
         }
     }*/
    /* private fun playBeep() {
         toneGenerator!!.startTone(ToneGenerator.TONE_CDMA_PIP)
     }
 */
    /*  private fun startListening() {
        telephonyManager.listen(object : PhoneStateListener() {
            override fun onServiceStateChanged(serviceState: android.telephony.ServiceState) {
                super.onServiceStateChanged(serviceState)
                if (serviceState.state == android.telephony.ServiceState.STATE_OUT_OF_SERVICE) {
                    // Network signal lost, play beep sound
                    startToneGeneration()
                    showGPSDialog()
                 //   toneGenerator!!.startTone(ToneGenerator.TONE_PROP_BEEP)
                }
                else
                {
                    stopToneGeneration()
                    dismissGPSDialog()
                }
            }
        }, PhoneStateListener.LISTEN_SERVICE_STATE)
    }
*/
    private fun startToneGeneration() {

        audioManager!!.setStreamVolume(
            AudioManager.STREAM_ALARM,
            audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM),
            AudioManager.FLAG_PLAY_SOUND
        )

        if (toneGenerator != null) {
            toneGenerator!!.startTone(ToneGenerator.TONE_CDMA_PIP)
        }
    }

    private fun stopToneGeneration() {

        if (toneGenerator != null) {
            toneGenerator!!.stopTone()
        }
    }

    private fun showGPSDialog() {

        handler!!.post {
            if (gpsDialog == null || !gpsDialog!!.isShowing) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("You can use this app only when you turn on the GPS location.")
                    .setCancelable(false)
                    .setPositiveButton(
                        "Enable GPS"
                    ) { dialog, which -> // Open location settings when positive button clicked
                        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                        dialog.cancel()
                    }
                    .setNegativeButton(
                        "Cancel"
                    ) { dialog, which -> // Cancel dialog
                        dialog.cancel()
                    }
                gpsDialog = builder.create()
                gpsDialog!!.show()
            }
        }
    }

    private fun dismissGPSDialog() {
        if (gpsDialog != null && gpsDialog!!.isShowing) {
            gpsDialog!!.dismiss()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MainActivity.Companion.REQUEST_LOCATION_PERMISSION) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                startCheckingGPSStatus()
            } else {

                Toast.makeText(this, "Location permission denied. App may not function properly.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 1001
        private const val REQUEST_INTERNET_PERMISSION = 1002
        //    private const val PERMISSION_REQUEST_CODE = 101
    }
}