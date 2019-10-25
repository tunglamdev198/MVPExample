package com.lamnt.mvpexample.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lamnt.mvpexample.database.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    User getOne(String email, String password);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createUser(User user);
}
