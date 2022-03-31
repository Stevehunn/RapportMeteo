package com.example.weatherreport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        // If you want Icon display in Overflow Menu.
        // https://stackoverflow.com/questions/19750635/icon-in-menu-not-showing-in-android
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_temperature:
                Intent a = new Intent(MainActivity.this, Temperature.class);
                startActivity(a);
                onPause();
                break;
            case R.id.action_humidite:
                Intent b = new Intent(MainActivity.this, Humidite.class);
                startActivity(b);
                onPause();
                break;
            case R.id.action_luminosite:
                Intent c = new Intent(MainActivity.this, Luminosite.class);
                startActivity(c);
                onPause();
                break;
            case R.id.action_pollution:
                Intent d = new Intent(MainActivity.this, Pollution.class);
                startActivity(d);
                onPause();
                break;
            case R.id.action_tvoc:
                Intent e = new Intent(MainActivity.this, Tvoc.class);
                startActivity(e);
                onPause();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
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