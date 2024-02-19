package com.example.viewbinding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewbinding.databinding.ActivityPlacingBetsBinding;

public class Placing_bets extends AppCompatActivity {

    ImageButton dollar1000, dollar500, dollar5000, dollar10k, dollar100k;
    EditText walletMoney;
    ImageView background2 , throwAreaImage, dollar500image , dollar1000image , dollar5000image ,dollar10kimage, dollar100kimage;
    private ActivityPlacingBetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlacingBetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dollar500 = findViewById(R.id.dollar500);
        dollar1000 = findViewById(R.id.dollar1000);
        dollar5000 = findViewById(R.id.dollar5000);
        dollar10k = findViewById(R.id.dollar10k);
        dollar100k = findViewById(R.id.dollar100k);
        walletMoney = findViewById(R.id.walletMoney);
        background2 = findViewById(R.id.background2);
        throwAreaImage = findViewById(R.id.throwAreaImage);
        dollar500image = findViewById(R.id.dollar500image);
        dollar1000image = findViewById(R.id.dollar1000image);
        dollar5000image = findViewById(R.id.dollar5000image);
        dollar10kimage = findViewById(R.id.dollar10k);
        dollar100kimage = findViewById(R.id.dollar100kimage);


        dollar500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwMoney(500);
//                Animation animation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.enter_up);
//                Animation rotateAnimation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.rotate);
//                dollar500.startAnimation(animation);
//                dollar500.startAnimation(rotateAnimation);
                moveDollarImageToThrowArea500();
            }
        });

        dollar1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwMoney(1000);
//                Animation animation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.enter_up);
//                Animation rotateAnimation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.rotate);
//                dollar1000.startAnimation(animation);
                moveDollarImageToThrowArea1000();

            }
        });

        dollar5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwMoney(5000);
//                Animation animation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.enter_up);
//                Animation rotateAnimation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.rotate);
//                dollar5000.startAnimation(animation);
                moveDollarImageToThrowArea5000();
            }
        });

        dollar10k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwMoney(10000);
//                Animation animation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.enter_up);
//                Animation rotateAnimation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.rotate);
//                dollar10k.startAnimation(animation);
                moveDollarImageToThrowArea10k();
            }
        });

        dollar100k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwMoney(100000);
//                Animation animation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.enter_up);
//                Animation rotateAnimation = AnimationUtils.loadAnimation(Placing_bets.this, R.anim.rotate);
//                dollar100k.startAnimation(animation);
                moveDollarImageToThrowArea100k();
            }
        });
    }

    public void throwMoney(int amount) {
        int currentAmount = getCurrentWalletAmount();

        // Check if wallet has sufficient funds
        if (currentAmount < amount) {
            Toast.makeText(this, "Insufficient funds in wallet", Toast.LENGTH_SHORT).show();
            return;
        }

        // Deduct the amount from the wallet
        int updatedAmount = currentAmount - amount;
        updateWalletAmount(updatedAmount);

        String message = "Throwing Money: $" + amount;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private int getCurrentWalletAmount() {
        String currentAmountString = walletMoney.getText().toString();
        if (currentAmountString.isEmpty()) {
            // Set default wallet amount to $300,000
            return 300000;
        } else {
            return Integer.parseInt(currentAmountString);
        }
    }

    private void updateWalletAmount(int amount) {
        walletMoney.setText(String.valueOf(amount));
    }

    private void moveDollarImageToThrowArea500() {
        float startX = dollar500image.getX();
        float startY = dollar500image.getY();
        float endX = throwAreaImage.getX() + throwAreaImage.getWidth() / 2 - dollar500image.getWidth() / 2;
        float endY = throwAreaImage.getY() + throwAreaImage.getHeight() / 2 - dollar500image.getHeight() / 2;

        ObjectAnimator moveX = ObjectAnimator.ofFloat(dollar500image, "x", startX, endX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(dollar500image, "y", startY, endY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void moveDollarImageToThrowArea1000() {
        float startX = dollar1000image.getX();
        float startY = dollar1000image.getY();
        float endX = throwAreaImage.getX() + throwAreaImage.getWidth() / 2 - dollar1000image.getWidth() / 2;
        float endY = throwAreaImage.getY() + throwAreaImage.getHeight() / 2 - dollar1000image.getHeight() / 2;

        ObjectAnimator moveX = ObjectAnimator.ofFloat(dollar1000image, "x", startX, endX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(dollar1000image, "y", startY, endY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void moveDollarImageToThrowArea5000() {
        float startX = dollar5000image.getX();
        float startY = dollar5000image.getY();
        float endX = throwAreaImage.getX() + throwAreaImage.getWidth() / 2 - dollar5000image.getWidth() / 2;
        float endY = throwAreaImage.getY() + throwAreaImage.getHeight() / 2 - dollar5000image.getHeight() / 2;

        ObjectAnimator moveX = ObjectAnimator.ofFloat(dollar5000image, "x", startX, endX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(dollar5000image, "y", startY, endY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void moveDollarImageToThrowArea10k() {
        float startX = dollar10kimage.getX();
        float startY = dollar10kimage.getY();
        float endX = throwAreaImage.getX() + throwAreaImage.getWidth() / 2 - dollar10kimage.getWidth() / 2;
        float endY = throwAreaImage.getY() + throwAreaImage.getHeight() / 2 - dollar10kimage.getHeight() / 2;

        ObjectAnimator moveX = ObjectAnimator.ofFloat(dollar10kimage, "x", startX, endX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(dollar10kimage, "y", startY, endY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void moveDollarImageToThrowArea100k() {
        float startX = dollar100kimage.getX();
        float startY = dollar100kimage.getY();
        float endX = throwAreaImage.getX() + throwAreaImage.getWidth() / 2 - dollar100kimage.getWidth() / 2;
        float endY = throwAreaImage.getY() + throwAreaImage.getHeight() / 2 - dollar100kimage.getHeight() / 2;

        ObjectAnimator moveX = ObjectAnimator.ofFloat(dollar100kimage, "x", startX, endX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(dollar100kimage, "y", startY, endY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }



}