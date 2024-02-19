package com.example.fadeout;

import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    // on below line creating a
    // variable for image view and button.
    private ImageView imageView;
    private Button encBtn, decBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on below line initializing the variables.
        imageView = findViewById(R.id.idIVimage);
        encBtn = findViewById(R.id.idBtnEncrypt);
        decBtn = findViewById(R.id.idBtnDecrypt);

        // on below line adding click listener for encrypt button.
        encBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are picking the image to encrypt it.
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);
            }
        });

        // on below line adding click listener for decrypt button.
        decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line calling decrypt
                // method to decrypt our image.
                try {
                    decrypt();
                } catch (Exception e) {
                    // displaying a toast message
                    // if decryption fails.
                    Toast.makeText(MainActivity.this, "Fail to decrypt image", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    public void decrypt() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        // on below line creating and initializing variable for context wrapper.
        ContextWrapper contextWrapper = new ContextWrapper(getApplication());

        // on below line creating a file for getting photo directory.
        File photoDir = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DCIM);

        // on below line creating a new file for encrypted image.
        File file = new File(photoDir, "encfile" + ".png");

        // on below line creating input stream for file with file path.
        FileInputStream fis = new FileInputStream(file.getPath());

        // on below line creating a file for decrypted image.
        File decFile = new File(photoDir, "decfile.png");

        // on below line creating an file output stream for decrypted image.
        FileOutputStream fos = new FileOutputStream(decFile.getPath());

        // creating a variable for secret key and passing our secret key
        // and algorithm for encryption.
        SecretKeySpec sks = new SecretKeySpec("KERQIRUDYTH".getBytes(), "AES");

        // on below line creating a variable
        // for cipher and initializing it
        Cipher cipher = Cipher.getInstance("AES");

        // on below line initializing cipher and
        // specifying decrypt mode to decrypt.
        cipher.init(Cipher.DECRYPT_MODE, sks);

        // on below line creating a variable for cipher input stream.
        CipherInputStream cis = new CipherInputStream(fis, cipher);

        // on below line creating a variable b.
        int b;
        byte[] d = new byte[8];
        while ((b = cis.read(d)) != -1) {
            fos.write(d, 0, b);
        }

        // on below line flushing our fos,
        // closing fos and closing cis.
        fos.flush();
        fos.close();
        cis.close();

        // displaying toast message.
        Toast.makeText(this, "File decrypted successfully..", Toast.LENGTH_SHORT).show();

        // on below line creating an image file
        // from decrypted image file path.
        File imgFile = new File(decFile.getPath());
        if (imgFile.exists()) {
            // creating bitmap for image and displaying
            // that bitmap in our image view.
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getPath());
            imageView.setImageBitmap(bitmap);
        }
    }

    // on below line creating a method to encrypt an image.
    private void encrypt(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        // on below line creating a variable for file input stream
        FileInputStream fis = new FileInputStream(path);

        // on below line creating a variable for context wrapper.
        ContextWrapper contextWrapper = new ContextWrapper(getApplication());

        // on below line creating a variable for file
        File photoDir = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DCIM);

        // on below line creating a file for encrypted file.
        File file = new File(photoDir, "encfile" + ".png");

        // on below line creating a variable for file output stream.
        FileOutputStream fos = new FileOutputStream(file.getPath());

        // on below line creating a variable for secret key.
        // creating a variable for secret key and passing our secret key
        // and algorithm for encryption.
        SecretKeySpec sks = new SecretKeySpec("KERQIRUDYTH".getBytes(), "AES");

        // on below line creating a variable for cipher and initializing it
        Cipher cipher = Cipher.getInstance("AES");

        // on below line initializing cipher and
        // specifying decrypt mode to encrypt.
        cipher.init(Cipher.ENCRYPT_MODE, sks);

        // on below line creating cos
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);
        int b;
        byte[] d = new byte[8];
        while ((b = fis.read(d)) != -1) {
            cos.write(d, 0, b);
        }

        // on below line closing
        // our cos and fis.
        cos.flush();
        cos.close();
        fis.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // on below line getting image uri
        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            // on below line getting image uri.
            Uri imgUri = data.getData();

            // on below line getting file path
            String[] filePath = {MediaStore.Images.Media.DATA};

            // on below line creating a cursor and moving to next.
            Cursor cursor = getContentResolver().query(imgUri, filePath, null, null, null);
            cursor.moveToFirst();

            // on below line creating an index for column
            int columnIndex = cursor.getColumnIndex(filePath[0]);

            // on below line creating a string for path.
            String picPath = cursor.getString(columnIndex);

            // on below line closing our cursor.
            cursor.close();

            // on below line we are encrypting our image.
            try {
                encrypt(picPath);
                // on below line we are encrypting our image.
                Toast.makeText(this, "Image encrypted..", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Fail to encrypt image : " + e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}


