package com.lamnt.mvpexample.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.lamnt.mvpexample.presenter.contract.LoginContract;
import com.lamnt.mvpexample.presenter.impl.LoginInteractorImpl;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;
    LoginInteractor interactor;


    public LoginPresenter() {
        interactor = new LoginInteractorImpl();
    }

    public void setView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void handleLogin(Context context, String email, String password) {
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            mView.loginFailed("Vui lòng nhập email và mật khẩu");
            return;
        }
        if (interactor.login(context, email, password)) {
            mView.loginSuccess();
        } else {
            mView.loginFailed("Email hoặc mật khẩu không đúng");
        }
    }
}
