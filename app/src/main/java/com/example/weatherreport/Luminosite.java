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
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luminosite);


        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        Button buttonVersPol = (Button) findViewById(R.id.buttonVersPol);
        Button buttonRefresh = (Button) findViewById(R.id.buttonRefresh);

        webView = (WebView) findViewById(R.id.afficheFieldPol);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setInitialScale(220);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://thingspeak.com/channels/1686204/charts/3?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+Luminosit%C3%A9&type=line");


        //Bouton pour aller vers la page d'accueil

        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Luminosite", "Home");
                Intent i = new Intent(Luminosite.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le capteur d'humidité
        buttonVersPol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Luminosite", "versPol");

                Intent i = new Intent(Luminosite.this, Pollution.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour refresh
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("refresh", "refresh");
                Luminosite.this.webView.loadUrl("https://thingspeak.com/channels/1686204/charts/3?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+Luminosit%C3%A9&type=line");
            }
        });
    }


    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}