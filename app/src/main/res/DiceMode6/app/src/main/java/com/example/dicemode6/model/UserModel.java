package com.example.dicemode6.model;

import com.google.firebase.Timestamp;

public class UserModel {
    private String username;
    private String phone;
    private Timestamp createdtimestamp;
    private String userId;
    private String fcmToken;


    public UserModel(){
    }

    public UserModel(String username, String phone, Timestamp createdtimestamp, String userId, String fcmToken) {
        this.username = username;
        this.phone = phone;
        this.createdtimestamp = createdtimestamp;
        this.userId = userId;
        this.fcmToken = fcmToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreatedtimestamp() {
        return createdtimestamp;
    }

    public void setCreatedtimestamp(Timestamp createdtimestamp) {
        this.createdtimestamp = createdtimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
