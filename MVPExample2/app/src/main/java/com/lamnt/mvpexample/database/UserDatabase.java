package com.lamnt.mvpexample.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.lamnt.mvpexample.database.dao.UserDao;
import com.lamnt.mvpexample.database.entities.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
