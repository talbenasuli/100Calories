package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Register;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.Main.Main.Models.Model;

public class RegisterPresentor implements Model.RegisterListener {

    private RegisterPresentorListener listener;
    public interface RegisterPresentorListener {
        void moveToHome();
    }

    void onRegisterTapped(UserDetails userDetails, String password) {
        if(userDetails != null) {
            Model.getInstance().createUserWithEmailAndPassword(userDetails,
                    password,this);
        }
    }

    public void setListener(RegisterPresentorListener listener) {
        this.listener = listener;
    }

    @Override
    public void onRegisterComplete() {
        listener.moveToHome();
    }

    @Override
    public void onRegisterError() { //TODO:- add toast when error.
    }
}
