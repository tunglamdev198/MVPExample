package com.lamnt.mvpexample.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lamnt.mvpexample.R;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEmailOrPhone;
    private RelativeLayout btnFacebook;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initViews();
        registerListener();
    }

    private void initViews() {
        btnEmailOrPhone = findViewById(R.id.btn_email_or_phone);
        btnFacebook = findViewById(R.id.btn_facebook);
        txtLogin = findViewById(R.id.txt_login);
    }

    private void registerListener() {
        btnFacebook.setOnClickListener(this);
        btnEmailOrPhone.setOnClickListener(this);
        txtLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_email_or_phone:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.txt_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
