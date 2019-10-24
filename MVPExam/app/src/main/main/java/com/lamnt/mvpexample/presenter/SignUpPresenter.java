package com.lamnt.mvpexample.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.lamnt.mvpexample.database.entities.User;
import com.lamnt.mvpexample.database.repository.UserRepository;
import com.lamnt.mvpexample.presenter.contract.SignUpContract;

public class SignUpPresenter implements SignUpContract.Presenter {
    SignUpContract.View mView;

    public void setView(SignUpContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void handleRegister(Context context, String email, String username, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mView.registerFailed("Vui lòng nhập đủ thông tin");
            return;
        }
        User user = new User(email, password, username);
        UserRepository.getInstance(context).createUser(user);
        mView.registerSuccess();
    }
}
