package com.example.encrypt_decryptapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText inputTextactivity02;
    private EditText encryptKeyactivity02;
    private EditText decryptKeyactivity02;
    private EditText encryptedTextactivity02;
    private EditText decryptedTextactivity02;
    private Button encryptButtonactivity02;
    private Button decryptButtonactivity02;
    private EditText decryptedTextresult02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputTextactivity02 = findViewById(R.id.editTextTextMultiLineActivity02);
        encryptKeyactivity02 = findViewById(R.id.encrypt_keyActivity02);
        decryptKeyactivity02 = findViewById(R.id.decrypt_keyActivity02);
        encryptedTextactivity02 = findViewById(R.id.editTextTextMultiLine2Activity02);
        decryptedTextactivity02 = findViewById(R.id.editTextTextMultiLine3Activity02);
        encryptButtonactivity02 = findViewById(R.id.button4Activity02);
        decryptButtonactivity02 = findViewById(R.id.button3Activity02);
        decryptedTextresult02 = findViewById(R.id.editTextTextMultiLine4Activity02);

        encryptButtonactivity02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = inputTextactivity02.getText().toString();
                String encryptKey = encryptKeyactivity02.getText().toString();

                if (TextUtils.isEmpty(inputText) || TextUtils.isEmpty(encryptKey)) {
                    Toast.makeText(MainActivity2.this, "Please enter text and encryption key", Toast.LENGTH_SHORT).show();
                    return;
                }

                String encryptedText = encryptText(inputText, encryptKey);
                encryptedTextactivity02.setText(encryptedText);
            }
        });

        decryptButtonactivity02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encryptedText = decryptedTextactivity02.getText().toString();
                String decryptKey = decryptKeyactivity02.getText().toString();

                if (TextUtils.isEmpty(encryptedText) || TextUtils.isEmpty(decryptKey)) {
                    Toast.makeText(MainActivity2.this, "Please enter text and decryption key", Toast.LENGTH_SHORT).show();
                    return;
                }

                String decryptedText = decryptText(encryptedText, decryptKey);
                decryptedTextresult02.setText(decryptedText);
            }
        });
    }

    private String encryptText(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();

        int keyInt = Integer.parseInt(key);

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (ch == ' ') {
                encryptedText.append(' ');
            } else if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) ((ch + keyInt - 'A') % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                char encryptedChar = (char) ((ch + keyInt - 'a') % 26 + 'a');
                encryptedText.append(encryptedChar);
            }
        }

        return encryptedText.toString();
    }

    private String decryptText(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();

        int keyInt = Integer.parseInt(key);

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);

            if (ch == ' ') {
                decryptedText.append(' ');
            } else if (Character.isUpperCase(ch)) {
                char decryptedChar = (char) ((ch - keyInt - 'A' + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);
            } else {
                char decryptedChar = (char) ((ch - keyInt - 'a' + 26) % 26 + 'a');
                decryptedText.append(decryptedChar);
            }
        }

        return decryptedText.toString();
    }
}
