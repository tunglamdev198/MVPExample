package com.lamnt.mvpexample.presenter.contract;

import android.content.Context;

public interface LoginContract {
    interface View {
        void loginSuccess();

        void loginFailed(String error);
    }

    interface Presenter {
        void handleLogin(Context context, String email, String password);
    }
}
