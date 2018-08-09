package com.example.talbe.a100calories.Main.Main.UserInterface.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.talbe.a100calories.R;

public class RegisterTextFields extends LinearLayout
                                implements View.OnClickListener{

    public interface RegisterTextFieldsListener {
         void registerTextFieldsOnBack();
    }
    RegisterTextFieldsListener listener;

    //Params:
    TextView backTextView;

    public RegisterTextFields(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    private void inflate(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.register_textfields, this);
        backTextView = findViewById(R.id.registerTextFieldsBack);
        backTextView.setOnClickListener(this);
    }

    public void setListener(RegisterTextFieldsListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

        if(view == backTextView) {
            listener.registerTextFieldsOnBack();
        }
    }
}
