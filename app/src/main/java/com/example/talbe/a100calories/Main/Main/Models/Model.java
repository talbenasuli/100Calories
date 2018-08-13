package com.example.talbe.a100calories.Main.Main.Models;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;

public class Model {

    // Parameters:
    private static final Model ourInstance = new Model();
    private FirebaseModel firebaseModel;

    // Constractors:
    private Model() {
        firebaseModel = new FirebaseModel();
    }

    public interface RegisterListener {
        void onRegisterComplete();
        void onRegisterError();
    }
    public void createUserWithEmailAndPassword(UserDetails userDetails, String password,
                                        RegisterListener listener) {
        firebaseModel.createUserWithEmailAndPassword(userDetails, password, listener);
    }

    public interface LoginListener {
        void onLoginComplete();
        void onLoginError();
    }
    public void login(String email, String password, LoginListener listener) {
        firebaseModel.login(email, password, listener);
    }

    // Functions:
    public static Model getInstance() {
        return ourInstance;
    }
}
