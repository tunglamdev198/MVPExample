package com.lamnt.mvpexample.presenter.impl;

import android.content.Context;

import com.lamnt.mvpexample.database.entities.User;
import com.lamnt.mvpexample.database.repository.UserRepository;
import com.lamnt.mvpexample.presenter.LoginInteractor;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public Boolean login(Context context, String email, String password) {
        User user = UserRepository.getInstance(context).getOne(email, password);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
