@file:Suppress("DEPRECATION")

package com.example.assignment4

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


/*Create an application to load google url into web view also manage forward
and backward redirect*/
class MainActivity9 : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        webView = findViewById(R.id.webview)
        webView.webViewClient = MyWebViewClient(this)
        webView.loadUrl("https://www.google.com")
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled=true

        onBackPressed()

    }

    class MyWebViewClient internal constructor(private val mainActivity9: MainActivity9) : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString()
            view?.loadUrl(url)
            return true
        }
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }
        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(mainActivity9, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed()
    {
        if(webView.canGoBack())
        {
            webView.goBack()
        }
        else
        {
            super.onBackPressed()
        }
    }

//pending

}

