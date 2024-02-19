package com.example.dice_mode_3;
import android.app.Activity;
import android.os.Bundle;

public class Snake_Dice extends Activity {

    private SnakeGameView snakeGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_dice);

        snakeGameView = findViewById(R.id.surfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        snakeGameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        snakeGameView.pause();
    }
}