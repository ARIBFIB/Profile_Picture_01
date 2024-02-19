package com.example.dice_mode_3;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static final int SNAKE_SIZE = 50;
    public static final int GAME_SPEED = 200; // Milliseconds

    private List<SnakePart> snakeParts;
    private Handler handler;
    private boolean isGameRunning;

    public Snake() {
        snakeParts = new ArrayList<>();
        snakeParts.add(new SnakePart(0, 0)); // Initial position of the snake
        handler = new Handler();
    }

    public List<SnakePart> getSnakeParts() {
        return snakeParts;
    }

    public void startGame() {
        isGameRunning = true;
        handler.postDelayed(gameLoop, GAME_SPEED);
    }

    public void stopGame() {
        isGameRunning = false;
        handler.removeCallbacks(gameLoop);
    }

    private Runnable gameLoop = new Runnable() {
        @Override
        public void run() {
            if (isGameRunning) {
                // Update the game state
                moveSnake();

                // Redraw the view
                // TODO: Get reference to SnakeGameView and call its invalidate() method

                // Schedule the next iteration
                handler.postDelayed(this, GAME_SPEED);
            }
        }
    };

    private void moveSnake() {
        // TODO: Implement the logic to move the snake
    }

    public class SnakePart {
        private int x;
        private int y;

        public SnakePart(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}