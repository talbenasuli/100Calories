package com.example.talbe.a100calories.Main.Main.UserInterface.LoginAndRegister.Login;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.Main.Main.Models.Model;
import com.example.talbe.a100calories.Main.Main.UserInterface.Common.ContainerActivity;
import com.example.talbe.a100calories.Main.Main.UserInterface.Views.LoginTextFields;
import com.example.talbe.a100calories.R;

public class LoginFragment extends Fragment
                           implements LoginTextFields.LoginTextFieldsListener, Model.LoginListener {

    public static String TAG = "LoginFragment";
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private LoginFragmentListener activityListener;

    public interface LoginFragmentListener extends ContainerActivity.ContainerActivityInterface {
        void onNewAccountClicked();
        void moveToHome();
    }

    // Parameters
    LoginTextFields loginTextFields;
    LoginPresentor loginPresentor = new LoginPresentor();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            activityListener = (LoginFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity " + getActivity().getClass().getName() + " must implement PILoginFragmentListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View loginFragment = inflater.inflate(R.layout.login_fragment, container, false);
        return loginFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginTextFields = view.findViewById(R.id.loginTextFields);
        loginTextFields.setListener(this);
    }

    @Override
    public void onNewAccountClicked() {
        activityListener.onNewAccountClicked();
    }

    @Override
    public void onLoginClicked(String email, String password) {
        activityListener.showProgressBar();
        loginPresentor.onLogin(email, password, this);
    }

    @Override
    public void onLoginComplete() {
        activityListener.hideProgressBar();
        activityListener.moveToHome();
    }

    @Override
    public void onLoginError() {
        String message = getResources().getString(R.string.login_fails_message);
        Toast.makeText(getContext(),message , Toast.LENGTH_LONG);
    }

}
