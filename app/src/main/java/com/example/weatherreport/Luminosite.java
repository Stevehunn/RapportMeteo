package com.example.weatherreport;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Luminosite extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luminosite);
       WebView webViewPol;

        webViewPol = (WebView) findViewById(R.id.afficheFieldLum);
        WebSettings webSettings = webViewPol.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewPol.setWebViewClient(new WebViewClient());
        webViewPol.loadUrl("https://thingspeak.com/channels/1686204/charts/3?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");
    }
}