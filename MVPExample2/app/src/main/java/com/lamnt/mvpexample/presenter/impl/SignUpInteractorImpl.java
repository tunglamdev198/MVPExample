package com.lamnt.mvpexample.presenter.impl;

import android.content.Context;

import com.lamnt.mvpexample.database.entities.User;
import com.lamnt.mvpexample.database.repository.UserRepository;
import com.lamnt.mvpexample.presenter.SignUpInteractor;

public class SignUpInteractorImpl implements SignUpInteractor {
    @Override
    public boolean register(Context context, String username, String password, String email) {
        if (UserRepository.getInstance(context).getOne(email, password) == null) {
            User user = new User(email, password, username);
            UserRepository.getInstance(context).createUser(user);
            return true;
        } else
            return false;
    }
}
