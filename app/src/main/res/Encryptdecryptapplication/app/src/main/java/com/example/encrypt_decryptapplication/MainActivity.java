package com.example.encrypt_decryptapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private EditText encryptedText;
    private Button encryptButton;

    private EditText inputText2;
    private EditText decryptedText;
    private Button decryptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputText = findViewById(R.id.editTextTextMultiLine);
        encryptedText = findViewById(R.id.editTextTextMultiLine2);
        encryptButton = findViewById(R.id.button4);

        inputText2 = findViewById(R.id.editTextTextMultiLine3);
        decryptedText = findViewById(R.id.editTextTextMultiLine4);
        decryptButton = findViewById(R.id.button3);


        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();
                String encrypted = encryptText(text);
                encryptedText.setText(encrypted);
            }
        });

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = inputText2.getText().toString();
                String decrypted = decryptText(text2);
                decryptedText.setText(decrypted);
            }
        });

    }

    private String encryptText(String text){
        byte[] data = text.getBytes();
        byte[] encryptedData = Base64.encode(data, Base64.DEFAULT);
        return  new String(encryptedData);
    }

    private String decryptText(String encrypted){
        byte[] encryptedData = encrypted.getBytes();
        byte[] decrypteddata = Base64.decode(encryptedData, Base64.DEFAULT);
        return new String(decrypteddata);
    }



}