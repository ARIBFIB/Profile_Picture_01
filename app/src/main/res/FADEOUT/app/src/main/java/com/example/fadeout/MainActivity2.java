package com.example.fadeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageViewSimple;
    ImageView imageViewEncrypted;
    ImageView pasteImageEncryptedView;
    ImageView decryptedImage;
    Button encryptionButton;
    Button decryptionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageViewSimple = findViewById(R.id.imageViewSimple);
        imageViewEncrypted = findViewById(R.id.imageViewEncrypted);
        pasteImageEncryptedView = findViewById(R.id.pasteImageEncryptedView);
        decryptedImage = findViewById(R.id.decryptedImage);

        encryptionButton = findViewById(R.id.button4);
        decryptionButton = findViewById(R.id.button3);


        imageViewSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        imageViewEncrypted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pasteImageEncryptedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        decryptedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        encryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        decryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void openGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(intent, 1);
    }

    public void  decryptedbuttonImage()throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        ContextWrapper contextWrapper = new ContextWrapper(getApplication());
        File photoDir = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DCIM);
    }
}