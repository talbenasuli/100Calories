package com.example.talbe.a100calories.Main.Main.UserInterface.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.talbe.a100calories.R;

public class LoginTextFields extends LinearLayout
                             implements View.OnClickListener{

    public interface LoginTextFieldsListener {
        void onNewAccountClicked();
    }

    LoginTextFieldsListener listener;
    TextView newAccountTextView;

    public LoginTextFields(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
        newAccountTextView = findViewById(R.id.loginTextFieldsNewAccount);
        newAccountTextView.setOnClickListener(this);
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
    }
}
