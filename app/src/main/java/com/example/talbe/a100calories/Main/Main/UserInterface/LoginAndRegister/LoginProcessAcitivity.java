package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.talbe.a100calories.Main.Main.UserInterface.Common.ContainerActivity;
import com.example.talbe.a100calories.Main.Main.UserInterface.Feed.FeedActivity;
import com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Login.LoginFragment;
import com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Register.RegisterFragment;
import com.example.talbe.a100calories.R;

public class LoginProcessAcitivity extends ContainerActivity
                                    implements LoginFragment.LoginFragmentListener,
                                                RegisterFragment.RegisterFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, currentFragment, LoginFragment.TAG)
                .commit();
    }

    @Override
    public void onNewAccountClicked() {
        currentFragment = RegisterFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, currentFragment, RegisterFragment.TAG)
                .commit();
    }

    @Override
    public void registerTextFieldsOnBack() {
        currentFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, currentFragment, LoginFragment.TAG)
                .commit();
    }

    @Override
    public void moveToHome() {
        Intent intent = new Intent(this, FeedActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void showProgressBar() {
        super.showProgressBar();
    }

    @Override
    public void hideProgressBar() {
        super.hideProgressBar();
    }
}
