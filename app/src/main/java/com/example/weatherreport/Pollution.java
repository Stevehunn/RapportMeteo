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

public class Pollution extends Activity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pollution);

        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        Button buttonRefresh = (Button) findViewById(R.id.buttonRefresh);

        webView = (WebView) findViewById(R.id.afficheFieldPol);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setInitialScale(240);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://thingspeak.com/channels/1686204/charts/4?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+Pollution&type=line");

        //Bouton pour aller vers la page d'accueil

        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Temperature", "Home");
                Intent i = new Intent(Pollution.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour refresh
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("refresh", "refresh");
                Pollution.this.webView.loadUrl("https://thingspeak.com/channels/1686204/charts/4?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Mesure+Pollution&type=line");
            }
        });

    }
}
