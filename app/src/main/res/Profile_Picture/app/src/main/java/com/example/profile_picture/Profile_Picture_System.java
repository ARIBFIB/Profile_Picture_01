package com.example.profile_picture;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile_Picture_System extends AppCompatActivity {

    ImageView cover;
    FloatingActionButton fab;
    FloatingActionButton changeProfile;
    CircleImageView profile;
    SharedPreferences sharedPreferences;

    private static final String PREF_IMAGE_URI = "pref_image_uri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_picture_system);

        cover = findViewById(R.id.coverimg);
        fab = findViewById(R.id.floatingActionButton);
        changeProfile = findViewById(R.id.changePofile);
        profile = findViewById(R.id.profile_image);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Profile_Picture_System.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }

        });


        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Profile_Picture_System.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(20);
            }
        });
        retrievedata();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 20) {
                Uri uri = data.getData();
                profile.setImageURI(uri);
                saveImageUri(uri.toString());
            } else if (requestCode == 10) {
                Uri uri = data.getData();
                cover.setImageURI(uri);
                saveImageUri(uri.toString());
            } else {
                Toast.makeText(Profile_Picture_System.this, "error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void retrievedata() {
        String imageUri = sharedPreferences.getString(PREF_IMAGE_URI, null);
        if (imageUri != null) {
            Uri uri = Uri.parse(imageUri);
            profile.setImageURI(uri);
            cover.setImageURI(uri);
        }
    }

    public void saveImageUri(String uri) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_IMAGE_URI, uri);
        editor.apply();
    }


}