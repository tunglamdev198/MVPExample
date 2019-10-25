package com.lamnt.mvpexample.presenter;

import android.content.Context;

public interface SignUpInteractor {
    boolean register(Context context, String username, String password, String email);
}
