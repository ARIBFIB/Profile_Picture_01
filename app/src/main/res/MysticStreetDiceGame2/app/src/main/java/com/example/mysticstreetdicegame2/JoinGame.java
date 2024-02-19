package com.example.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JoinGame extends AppCompatActivity {

    private Button btnJoinGame;
    private Button btnplaygame;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        btnplaygame = findViewById(R.id.btnplaygame);
        btnJoinGame = findViewById(R.id.btnJoinGame);


        btnJoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinGame();
                Toast.makeText(JoinGame.this, "Player 1 has turn", Toast.LENGTH_SHORT).show();


            }
        });


    }


    public void joinGame() {
        // Logic for joining a game
        Toast.makeText(this, "Joining a game...", Toast.LENGTH_SHORT).show();

        Intent intent;

        intent = new Intent(this, Hi_Low_throw.class);
        startActivity(intent);

        // Add your code to join a random game or challenge an online friend
        // Here's an example of joining a random game:
//        findRandomGame();
    }


    public void playrollDices() {
        // Logic for joining a game
        Toast.makeText(this, "Rolling dices...", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, GameLogic.class);
        startActivity(intent);

        // Add your code to join a random game or challenge an online friend
        // Here's an example of joining a random game:
//        findRandomGame();
    }


    private void findRandomGame() {
        // Implement the logic to find a random game
        // This can involve making API calls, querying a database, or any other appropriate method

        // Once a game is found, you can proceed with joining it
//         Here's an example of starting the game activity after finding a random game:
        startGameActivity();
    }

    private void startGameActivity() {
        // Start the game activity where the actual gameplay will take place
        // You can create an Intent to start the GameActivity or navigate to the appropriate screen

        Intent intent = new Intent(this, Hi_Low_throw.class);
        startActivity(intent);

    }
}

    // Other methods and logic for the rest of the game
