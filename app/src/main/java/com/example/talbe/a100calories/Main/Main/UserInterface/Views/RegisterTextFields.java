package com.example.talbe.a100calories.Main.Main.UserInterface.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.talbe.a100calories.Main.Main.Data.UserDetails;
import com.example.talbe.a100calories.R;

import java.util.regex.Matcher;

public class RegisterTextFields extends LinearLayout
                                implements View.OnClickListener{

    public interface RegisterTextFieldsListener {
         void registerTextFieldsOnBack();
         void registerTextFieldsOnRegister(UserDetails userDetails, String password);
         void registerTextFieldOnFail(String message);
    }
    RegisterTextFieldsListener listener;

    //Params:
    TextView backTextView;
    Button registerButton;

    // all editTexts:
    EditText emailEditText;
    EditText passwordEditText;
    EditText rePasswordEditText;
    EditText nameEditText;
    EditText lastNameEditText;
    EditText wightEditText;


    public RegisterTextFields(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    private void inflate(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.register_textfields, this);
        backTextView = findViewById(R.id.registerTextFieldsBack);
        backTextView.setOnClickListener(this);
        registerButton = findViewById(R.id.registerTextFieldsregisterButton);
        registerButton.setOnClickListener(this);
        emailEditText = findViewById(R.id.registerEmailEditText);
        passwordEditText = findViewById(R.id.registerPasswordEditText);
        rePasswordEditText = findViewById(R.id.registerRePasswordEditText);
        nameEditText = findViewById(R.id.registerName);
        lastNameEditText = findViewById(R.id.registerLastName);
        wightEditText = findViewById(R.id.registerWeight);
    }

    public void setListener(RegisterTextFieldsListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(view == backTextView) {
            listener.registerTextFieldsOnBack();
        } else if(view == registerButton) {
            onRegisterTapped();
        }
    }

    private void onRegisterTapped() {
        String password = passwordEditText.getText().toString();
        String rePassword = rePasswordEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String wight = wightEditText.getText().toString();
        if(password.isEmpty() || rePassword.isEmpty() ||
                email.isEmpty() || name.isEmpty() || lastName.isEmpty() || wight.isEmpty()) {
            listener.registerTextFieldOnFail(getResources().getString(R.string.emptyDetailsFailMessage));
        } else if(!password.equals(rePassword)) {
            listener.registerTextFieldOnFail(getResources().getString(R.string.rePasswordFailMessage));
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            listener.registerTextFieldOnFail(getResources().getString(R.string.emailFailMessage));
        } else {
            UserDetails userDetails = new UserDetails();
            userDetails.setEmail(email);
            userDetails.setName(name);
            userDetails.setLastName(lastName);
            userDetails.setWeight(Integer.parseInt(wight));
            listener.registerTextFieldsOnRegister(userDetails, password);
        }
    }
}
