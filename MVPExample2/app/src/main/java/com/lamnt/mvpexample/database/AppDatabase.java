package com.lamnt.mvpexample.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class AppDatabase {
    private static String DATABASE_NAME = "UserDemo";
    private UserDatabase database;
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context);
        }
        return instance;
    }

    private AppDatabase(Context context) {
        database = Room.databaseBuilder(context, UserDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build();
    }

    public UserDatabase getDatabase() {
        return database;
    }
}
