package com.example.dicemode6.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dicemode6.model.UserModel;

public class AndroidUtil {

    public static void showToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }



    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("UserName", model.getUsername());
        intent.putExtra("UserId", model.getUserId());
        intent.putExtra("FcmToken", model.getFcmToken());
        intent.putExtra("PhoneNumber", model.getPhone());
    }


    public static UserModel getUserModelFromIntent(Intent intent){
        UserModel userModel = new UserModel();
        userModel.setUsername(intent.getStringExtra("userName"));
        userModel.setUserId(intent.getStringExtra("userId"));
        userModel.setPhone(intent.getStringExtra("phone"));
        userModel.setFcmToken(intent.getStringExtra("fcmToken"));
        return userModel;
    }


    public static void profileImageCrop(Context context, Uri imageUri, ImageView imageView){
        Glide.with(context).load(imageUri).apply(RequestOptions.circleCropTransform()).into(imageView);
    }


}

