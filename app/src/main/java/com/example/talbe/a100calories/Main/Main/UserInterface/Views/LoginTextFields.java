package com.example.talbe.a100calories.Main.Main.UserInterface.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.R;

public class LoginTextFields extends LinearLayout
                             implements View.OnClickListener{

    public interface LoginTextFieldsListener {
        void onNewAccountClicked();
        void onLoginClicked(String email, String password);
    }

    LoginTextFieldsListener listener;
    TextView newAccountTextView;
    Button loginButton;

    // All edit text in the screen.
    EditText emailEditText;
    EditText passwordEditText;

    public LoginTextFields(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
        newAccountTextView = findViewById(R.id.loginTextFieldsNewAccount);
        newAccountTextView.setOnClickListener(this);
        loginButton = findViewById(R.id.loginTextFieldsLoginButton);
        loginButton.setOnClickListener(this);
        emailEditText = findViewById(R.id.loginTextFieldsEmailTextField);
        passwordEditText = findViewById(R.id.loginTextFieldsPasswordTextField);
    }

    private void inflate(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.login_textfields, this);
    }

    public void setListener(LoginTextFieldsListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(view == newAccountTextView) {
            listener.onNewAccountClicked();
        }
        else if(view == loginButton) {
            listener.onLoginClicked(emailEditText.getText().toString(), passwordEditText.getText().toString());
        }
    }
}
