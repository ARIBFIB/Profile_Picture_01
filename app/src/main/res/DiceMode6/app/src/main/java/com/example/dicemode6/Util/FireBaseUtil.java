package com.example.dicemode6.Util;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FireBaseUtil {


    public static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("users").document();
    }


    public static DocumentReference allusersDocumentsReference(){
        return FirebaseFirestore.getInstance().collection("users").document();
    }
}
