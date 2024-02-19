package com.example.mysticstreetdicegame2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameLogic extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    public Button btnplaygame;
    public ImageView imageView1, imageView2;
    public EditText playerScoreEditText, spectatorScoreEditText , playerTurnEdit , SpectatorEdit , pointSetEditText;
    private int playerScore, spectatorScore, point;

    int currentPlayer = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_logic);

        btnplaygame = findViewById(R.id.btnplaygame);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        playerScoreEditText = findViewById(R.id.playerScoreEdit);
        spectatorScoreEditText = findViewById(R.id.spectatorScoreEdit);
        SpectatorEdit = findViewById(R.id.spectatorTrunEdit);
        playerTurnEdit = findViewById(R.id.playerTurnEdit);
        pointSetEditText = findViewById(R.id.pointsSetsEdit);


        currentPlayer = (currentPlayer == 1) ? 2 : 1;

        String playerTurnText = "Player " + currentPlayer + "'s turn";
        String spectatorEdit = "Player " + ((currentPlayer == 1) ? 2 : 1) + " is spectator";

        Intent intent = getIntent();
        String turn = intent.getStringExtra("turn");
        playerTurnEdit.setText(turn);




        btnplaygame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                // Compare value1 and value2 to determine the highest number
//                int highestValue = Math.max(value1, value2);
//                String turn = (highestValue == value1) ? "Player 1's turn" : "Player 2's turn";
//
//                // Create an intent to start the GameLogic activity
//                Intent intent = new Intent(GameLogic.this, GameLogic.class);
//                intent.putExtra("turn", turn);
//                startActivity(intent);



                int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.viewbinding");
                int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.viewbinding");

                imageView1.setImageResource(res1);
                imageView2.setImageResource(res2);

                int sum = value1 + value2;
                if (point == 0){

                    if (sum == 7 || sum == 11){
                        playerScore++;
                        Toast.makeText(GameLogic.this, "player Wins! Roll again.", Toast.LENGTH_SHORT).show();
                    } else if (sum == 2 || sum == 3 || sum == 12){
                        spectatorScore++;
                        Toast.makeText(GameLogic.this, "Spectator wins! Roll again.", Toast.LENGTH_SHORT).show();
                    }else {
                        point = sum;
                        pointSetEditText.setText(String.valueOf(point));
                        Toast.makeText(GameLogic.this, "Points Set :" + point, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    //point set logic
                    if (sum == point){
                        playerScore++;
                        point = 0;
                        pointSetEditText.setText(String.valueOf(point));
                        Toast.makeText(GameLogic.this, "Player wins! Roll again.", Toast.LENGTH_SHORT).show();
                    } else if (sum == 7) {
                        spectatorScore++;
                        point = 0;
                        pointSetEditText.setText(String.valueOf(point));
                        Toast.makeText(GameLogic.this, "Spectator wins! Roll again.", Toast.LENGTH_SHORT).show();
                    }
                }

                updateScore();


                if (value1 + value2 == 7 || value1 + value2 == 11) {
                    Toast.makeText(GameLogic.this, "Player Wins! Roll Again ... ", Toast.LENGTH_SHORT).show();
                } else if (value1 + value2 == 2 || value1 + value2 == 3 || value1 + value2 == 12) {
                    Toast.makeText(GameLogic.this, "Spectator wins! Roll again.", Toast.LENGTH_SHORT).show();
                } else {
                    int point = value1 + value2;
                    Toast.makeText(GameLogic.this, "Points Sets", Toast.LENGTH_SHORT).show();
                }


                playerTurnEdit.setText(playerTurnText);
                SpectatorEdit.setText(spectatorEdit);
//                currentPlayer = (currentPlayer == 1) ? 2 : 1;
//                playerTurnEdit.setText("Player " + currentPlayer + "'s turn");
//                SpectatorEdit = "Player " + ((currentPlayer == 1) ? 2 : 1) + " is spectator";

            }
        });
    }

    public void logic(View v) {
        int value1 = randomDiceValue();
        int value2 = randomDiceValue();

        int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.viewbinding");
        int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.viewbinding");

        imageView1.setImageResource(res1);
        imageView2.setImageResource(res2);

        if (value1 + value2 == 7 || value1 + value2 == 11) {
            // Player wins
            Toast.makeText(this, "Player wins! Roll again.", Toast.LENGTH_SHORT).show();
        } else if (value1 + value2 == 2 || value1 + value2 == 3 || value1 + value2 == 12) {
            // Spectator wins
            Toast.makeText(this, "Spectator wins! Roll again.", Toast.LENGTH_SHORT).show();
        } else {
            // Point is set
            int point = value1 + value2;
            Toast.makeText(this, "Point is set: " + point, Toast.LENGTH_SHORT).show();
            // Add your code to handle the point and continue the game
            // For example, you can store the point value and proceed with the next roll
        }

    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }


    private void updateScore(){
        playerScoreEditText.setText(String.valueOf(playerScore));
        spectatorScoreEditText.setText(String.valueOf(spectatorScore));
    }
}