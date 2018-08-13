package com.example.talbe.a100calories.Main.Main.UserInterface.Common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.talbe.a100calories.R;

public class ContainerActivity extends AppCompatActivity {

    public interface ContainerActivityInterface {
        void showProgressBar();
        void hideProgressBar();
    }

    protected Fragment currentFragment;
    private ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_activity);
        progressBar = findViewById(R.id.containerProgressBar);
        progressBar.setVisibility(View.GONE);
    }

    protected void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
