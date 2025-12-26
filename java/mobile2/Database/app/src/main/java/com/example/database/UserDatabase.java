package com.example.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {UserModel.class},
        version = 1,
        exportSchema = false
)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DB_NAME = "user_database.db";

    private static volatile UserDatabase instance;

    public abstract UserDao userDao();

    public static UserDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (UserDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    UserDatabase.class,
                                    DB_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}