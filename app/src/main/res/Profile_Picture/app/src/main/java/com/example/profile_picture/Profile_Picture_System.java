package com.example.profile_picture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import com.github.dhaval2404.imagepicker.ImagePickerFileProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {

    ImageView cover;
    FloatingActionButton fab;
    FloatingActionButton changeProfile;
    CircleImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cover = findViewById(R.id.coverimg);
        fab = findViewById(R.id.floatingActionButton);
        changeProfile = findViewById(R.id.changePofile);
        profile = findViewById(R.id.profile_image);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity3.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }
        });
        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity3.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(20);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 20){
            Uri uri = data.getData();
            profile.setImageURI(uri);
        }
        else if (requestCode == 10) {
            Uri uri = data.getData();
            cover.setImageURI(uri);
        }
        else {
            Toast.makeText(MainActivity3.this, "error", Toast.LENGTH_SHORT).show();
        }
    }

}