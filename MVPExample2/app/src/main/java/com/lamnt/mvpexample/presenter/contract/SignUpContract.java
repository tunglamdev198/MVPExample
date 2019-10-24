package com.lamnt.mvpexample.presenter.contract;

import android.content.Context;

public interface SignUpContract {
    interface View {
        void registerSuccess();

        void registerFailed(String error);

        void navigateToLogin();
    }

    interface Presenter {
        void handleRegister(Context context, String email, String username, String password);
    }
}
