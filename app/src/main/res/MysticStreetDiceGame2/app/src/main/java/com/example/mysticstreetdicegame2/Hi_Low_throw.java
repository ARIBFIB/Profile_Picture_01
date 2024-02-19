package com.example.mysticstreetdicegame2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Hi_Low_throw extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    public Button rollDicesplayer1;
    public Button rollDicesplayer2;
    public ImageView imageView1, imageView2;
    public int player1Value, player2Value;
    public TextView player1TextResult, player2TextResult;
    int value1,value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_low_throw);

        rollDicesplayer1 = findViewById(R.id.rollDiceplayer1);
        rollDicesplayer2 = findViewById(R.id.rollDiceplayer2);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        player1TextResult = findViewById(R.id.player1TextResult);
        player2TextResult = findViewById(R.id.player2TextResult);

        rollDicesplayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1Value = playTurn(1);
                player2TextResult.setText(String.valueOf(player1Value));
                rollDicesplayer1.setEnabled(false);
                rollDicesplayer2.setEnabled(true);
            }
        });

        rollDicesplayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player2Value = playTurn(2);
                player1TextResult.setText(String.valueOf(player2Value));
                rollDicesplayer1.setEnabled(true);
                rollDicesplayer2.setEnabled(false);


            }

        });


        rollDicesplayer2.setEnabled(false);
    }

    public int playTurn(int player) {
        int value1 = randomDiceValue();
        int value2 = randomDiceValue();

        int totalValue = value1 + value2;


//        Intent intent = new Intent(Hi_Low_throw.this, GameLogic.class);
//        intent.putExtra("player1Score", value1);
//        intent.putExtra("player2Score", value2);
//        intent.putExtra("turn", (value1 > value2) ? "Player 1's turn" : "Player 2's turn");
//        startActivity(intent);






        int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.viewbinding");
        int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.viewbinding");

        imageView1.setImageResource(res1);
        imageView2.setImageResource(res2);





        if (player == 1) {
            return player1TurnLogic(totalValue);
        } else {
            return player2TurnLogic(totalValue);
        }
    }



    public int player1TurnLogic(int totalValue) {
        if (totalValue > 7) {
            showToast("Player 1 wins! Player 2 is the Spectator.");
        } else if (totalValue < 7) {
            showToast("Player 2 wins! Player 1 is the Spectator.");
        } else {
            showToast("It's a tie. Roll again.");
        }
        return totalValue;
    }



    public int player2TurnLogic(int totalValue) {
        if (totalValue > 7) {
            showToast("Player 2 wins! Player 1 is the Spectator.");
        } else if (totalValue < 7) {
            showToast("Player 1 wins! Player 2 is the Spectator.");
        } else {
            showToast("It's a tie. Roll again.");
        }

        gotonext();

        return totalValue;
    }

//
//        Intent intent = new Intent(this, GameLogic.class);
//        startActivity(intent);



        private void gotonext(){
        int highestValue1 = value1 + value2;
        highestValue1 = Math.max(player1Value,player2Value);
        String turn = (highestValue1 == player1Value) ? "Player 1's turn" : "Player 2's turn";
        // Create an intent to start the GameLogic activity
        Intent intent = new Intent(Hi_Low_throw.this, GameLogic.class);
        intent.putExtra("turn", turn);
        startActivity(intent);

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }


}