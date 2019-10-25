package com.lamnt.mvpexample.presenter;

import android.content.Context;

public interface LoginInteractor {
    Boolean login(Context context, String email, String password);
}
