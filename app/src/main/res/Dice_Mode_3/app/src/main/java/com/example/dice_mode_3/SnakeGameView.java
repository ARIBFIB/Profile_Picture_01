package com.example.dice_mode_3;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SnakeGameView extends SurfaceView implements SurfaceHolder.Callback {

    private Snake snake;
    private Paint paint;

    public SnakeGameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        snake = new Snake();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Start the game loop
        snake.startGame();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Not used
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Stop the game loop
        snake.stopGame();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.BLACK);

        // Draw the snake
        for (Snake.SnakePart part : snake.getSnakeParts()) {
            canvas.drawRect(part.getX(), part.getY(), part.getX() + Snake.SNAKE_SIZE, part.getY() + Snake.SNAKE_SIZE, paint);
        }
    }
}