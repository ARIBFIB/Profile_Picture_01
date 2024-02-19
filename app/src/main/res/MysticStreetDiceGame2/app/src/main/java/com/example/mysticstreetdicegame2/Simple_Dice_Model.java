package com.example.mysticstreetdicegame2;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class Simple_Dice_Model extends AppCompatActivity {

    private GLSurfaceView glView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_dice_model);

        glView = new MyGLSurfaceView(this);
        setContentView(glView);
    }
    protected void onPause(){
        super.onPause();
        glView.onPause();
    }

    protected void onResume() {
        super.onResume();
        glView.onResume();

    }

}