package com.lamnt.mvpexample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.lamnt.mvpexample.R;
import com.lamnt.mvpexample.presenter.LoginPresenter;
import com.lamnt.mvpexample.presenter.contract.LoginContract;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private Button btnLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        registerListener();
        initPresenter();
    }

    private void initViews() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void registerListener() {
        btnLogin.setOnClickListener(this);
    }

    private void initPresenter() {
        mPresenter = new LoginPresenter();
        mPresenter.setView(this);
    }

    private void login() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        mPresenter.handleLogin(this,email, password);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            login();
        }
    }
}
