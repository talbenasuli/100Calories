package com.example.talbe.a100calories.Main.Main.Models;

import android.support.annotation.NonNull;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FirebaseModel {

    // Params:
    private FirebaseAuth authenticator;
    private FirebaseDatabase database;

    // static strings:
    private static String usersDataBaseName = "usersData";


    public FirebaseModel() {
        authenticator = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    private FirebaseUser getCurrentUser() {
        return authenticator.getCurrentUser();
    }

    private void saveUserDetailsAfterRegistration(UserDetails userDetails) {
        DatabaseReference myRef = database.getReference(usersDataBaseName);
        Map<String, Object> value = new HashMap<>();
        value.put("first name", userDetails.getName());
        value.put("last name", userDetails.getLastName());
        value.put("email", userDetails.getEmail());
        value.put("weight", userDetails.getWeight());
        myRef.child(getCurrentUser().getUid()).setValue(value);
    }

    void createUserWithEmailAndPassword(final UserDetails userDetails, String password,
                                        final Model.RegisterListener listener) {
        authenticator.createUserWithEmailAndPassword(userDetails.getEmail(), password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    saveUserDetailsAfterRegistration(userDetails);
                    listener.onRegisterComplete();
                } else {
                    listener.onRegisterError();
                }
            }
        });
    }

    void login(String email, String password, final Model.LoginListener listener) {
        authenticator.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    listener.onLoginComplete();
                } else {
                    listener.onLoginError();
                }
            }
        });
    }
}
