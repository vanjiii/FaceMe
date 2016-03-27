package com.vanjiii.faceme.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vanjiii.faceme.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2500;  //milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed when the timer is over
                startActivity();
            }
        }, SplashScreenActivity.SPLASH_TIME_OUT);
    }

    private void startActivity() {
        Intent intent = new Intent(SplashScreenActivity.this, MainScreenActivity.class);
        startActivity(intent);

        finish();
    }
}