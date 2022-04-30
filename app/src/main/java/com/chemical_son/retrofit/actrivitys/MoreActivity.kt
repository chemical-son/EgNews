package com.chemical_son.retrofit.actrivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.chemical_son.retrofit.R

class MoreActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        val url = intent.getStringExtra("url")

        webView = findViewById(R.id.web_view)
        webView.loadUrl(url.toString())

    }
}