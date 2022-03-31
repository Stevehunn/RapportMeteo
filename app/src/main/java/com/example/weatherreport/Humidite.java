package com.example.weatherreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Humidite extends Activity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humidite);

        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        Button buttonVersLum = (Button) findViewById(R.id.buttonVersLum);

        webView = (WebView) findViewById(R.id.afficheFieldHum);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://thingspeak.com/channels/1686204/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");

        //Bouton pour aller vers la page d'accueil

        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "Home");
                Intent i = new Intent(Humidite.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le capteur de luminosité
        buttonVersLum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "versHum");

                Intent i = new Intent(Humidite.this, Luminosite.class);
                startActivity(i);
                onPause();
            }
        });

    }
}
