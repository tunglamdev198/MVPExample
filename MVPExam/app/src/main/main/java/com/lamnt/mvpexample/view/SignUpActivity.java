package com.lamnt.mvpexample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.lamnt.mvpexample.R;
import com.lamnt.mvpexample.presenter.SignUpPresenter;
import com.lamnt.mvpexample.presenter.contract.SignUpContract;

public class SignUpActivity extends AppCompatActivity
        implements SignUpContract.View, View.OnClickListener {
    private TextInputEditText edtEmail;
    private TextInputEditText edtUsername;
    private TextInputEditText edtPassword;
    private Button btnSignUp;
    private SignUpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        initPresenter();
        registerListener();
    }

    private void initViews() {
        edtEmail = findViewById(R.id.edt_email);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }

    private void registerListener() {
        btnSignUp.setOnClickListener(this);
    }

    private void initPresenter() {
        mPresenter = new SignUpPresenter();
        mPresenter.setView(this);
    }

    private void register() {
        String email = edtEmail.getText().toString().trim();
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        mPresenter.handleRegister(this, email, username, password);
    }

    @Override
    public void onClick(View view) {
        register();
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToLogin() {

    }
}
