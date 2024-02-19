package com.example.encrypt_decryptapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    ImageView ivSplashscreen;
    private static final int SPLASH_DELAY = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivSplashscreen = findViewById(R.id.ivSplashscreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen.this, Dashboard.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_DELAY);

    }
}