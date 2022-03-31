package com.example.weatherreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Luminosite extends Activity {

    private WebView webViewPol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luminosite);

        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        Button buttonVersPol = (Button) findViewById(R.id.buttonVersPol);

        webViewPol = (WebView) findViewById(R.id.afficheFieldLum);
        WebSettings webSettings = webViewPol.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewPol.setWebViewClient(new WebViewClient());
        webViewPol.loadUrl("https://thingspeak.com/channels/1686204/charts/3?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");

        //Bouton pour aller vers la page d'accueil

        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "Home");
                Intent i = new Intent(Luminosite.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le capteur de Pollution
        buttonVersPol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "versHum");

                Intent i = new Intent(Luminosite.this, Pollution.class);
                startActivity(i);
                onPause();
            }
        });
    }
}