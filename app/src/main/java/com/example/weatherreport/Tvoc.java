package com.example.weatherreport;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tvoc extends Activity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tvoc);

        //Definition des boutons
        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        Button buttonVersHum = (Button) findViewById(R.id.buttonVersHum);
        Button buttonRefresh = (Button) findViewById(R.id.buttonRefresh);

        //Definition des paramètres de la webview
        webView = (WebView) findViewById(R.id.afficheFieldTvoc);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://thingspeak.com/channels/1686204/charts/5?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+TVOC&type=line");

        //Orientation du téléphone
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            webView.setInitialScale(400);
        } else {
            // In portrait
            webView.setInitialScale(220);
        }

        //Bouton pour aller vers la page d'accueil

        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "Home");
                Intent i = new Intent(Tvoc.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });


        //Bouton pour refresh
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("refresh", "refresh");
                Tvoc.this.webView.loadUrl("https://thingspeak.com/channels/1686204/charts/5?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+TVOC&type=line");
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