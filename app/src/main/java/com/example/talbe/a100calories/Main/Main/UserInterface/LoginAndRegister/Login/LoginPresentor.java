package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Login;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.Main.Main.Models.Model;

public class LoginPresentor {

    void onLogin(String email, String password, Model.LoginListener listener) {
        if( !email.isEmpty() && !password.isEmpty()) {
            Model.getInstance().login(email, password, listener);
        }
    }
}
