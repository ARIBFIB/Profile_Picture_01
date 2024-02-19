package com.example.gamedesign2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Random;

public class Dice_mode_2 extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    int playerValue;
    ImageView imageDice, imageView9 , imageView10, imageView12, imageView13, imageView14, imageView15;
    TextView textView4, textView6;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_mode_2);

        // Initialize views
        button = findViewById(R.id.button);
        imageDice = findViewById(R.id.imageDice);
        textView4 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView6);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);

        button.setOnClickListener(new View.OnClickListener() {
            int result4Value = 0;

            @Override
            public void onClick(View view) {
                playerValue = playTurn(1);
                textView6.setText(String.valueOf(playerValue));

                result4Value += playerValue;
                textView4.setText(String.valueOf(result4Value));
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterup();

            }
        });
    }

    private int playTurn(int player) {
        int value1 = randomDiceValue();
        int totalValue = value1;

        int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.gamedesign2");
        imageDice.setImageResource(res1);

        if (player == 1) {
            return addingNumbersLogic(totalValue);
        }

        return 0;
    }

    private int addingNumbersLogic(int totalValue) {
        return totalValue;
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    public void enterfromBottom(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
        imageView9.startAnimation(animation);
    }

    public void enterUp(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_up);
        imageView9.startAnimation(animation);
    }
    public void enterDown(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_down);
        imageView9.startAnimation(animation);
    }
    public void enterfromUp(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_up);
        imageView9.startAnimation(animation);
    }
    public void enterfromBottom(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
        imageView9.startAnimation(animation);
    }




}