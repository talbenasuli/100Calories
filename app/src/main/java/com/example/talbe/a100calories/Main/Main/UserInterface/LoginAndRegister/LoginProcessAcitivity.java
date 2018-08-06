package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Login.LoginFragment;
import com.example.talbe.a100calories.R;

public class LoginProcessAcitivity extends AppCompatActivity
                                    implements LoginFragment.LoginFragmentListener {

    private Fragment currentFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_activity);
        currentFragment = LoginFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, currentFragment, LoginFragment.TAG)
                .commit();
    }
}
