package com.lamnt.mvpexample.database.repository;

import android.content.Context;

import com.lamnt.mvpexample.database.AppDatabase;
import com.lamnt.mvpexample.database.dao.UserDao;
import com.lamnt.mvpexample.database.entities.User;

import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private static UserDao userDao;

    public static UserRepository getInstance(Context context) {
        if (instance == null) {
            instance = new UserRepository(context);
        }
        return instance;
    }

    private UserRepository(Context context) {
        userDao = AppDatabase.getInstance(context).getDatabase().getUserDao();
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getOne(String email,String password) {
        return userDao.getOne(email,password);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }


}
