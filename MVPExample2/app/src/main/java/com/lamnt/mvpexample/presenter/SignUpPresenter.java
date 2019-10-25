package com.lamnt.mvpexample.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.lamnt.mvpexample.presenter.contract.SignUpContract;
import com.lamnt.mvpexample.presenter.impl.SignUpInteractorImpl;

public class SignUpPresenter implements SignUpContract.Presenter {
    SignUpContract.View mView;
    SignUpInteractor interactor;

    public void setView(SignUpContract.View mView) {
        this.mView = mView;
        interactor = new SignUpInteractorImpl();
    }

    @Override
    public void handleRegister(Context context, String email, String username, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mView.registerFailed("Vui lòng nhập đủ thông tin");
            return;
        }
        if (interactor.register(context, username, password, email)) {
            mView.registerSuccess();
        } else {
            mView.registerFailed("Tài khoản này đã tồn tại");
        }

    }
}
