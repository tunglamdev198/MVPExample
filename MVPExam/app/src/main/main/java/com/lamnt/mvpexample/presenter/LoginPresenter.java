package com.lamnt.mvpexample.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.lamnt.mvpexample.database.entities.User;
import com.lamnt.mvpexample.database.repository.UserRepository;
import com.lamnt.mvpexample.presenter.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;

    public void setView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void handleLogin(Context context,String email, String password) {
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            mView.loginFailed("Vui lòng nhập email và mật khẩu");
            return;
        }
        User user = UserRepository.getInstance(context).getOne(email, password);
        if (user != null) {
            mView.loginSuccess();
        } else {
            mView.loginFailed("Email hoặc mật khẩu không đúng");
        }
    }
}
