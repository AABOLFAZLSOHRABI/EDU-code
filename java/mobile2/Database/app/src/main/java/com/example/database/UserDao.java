package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    long insertUser(UserModel user);

    @Update
    int updateUser(UserModel user);

    @Delete
    int deleteUser(UserModel user);

    @Query("SELECT * FROM users")
    List&lt;UserModel&gt; getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    UserModel getUserById(long id);

    @Query("DELETE FROM users")
    void deleteAll();
}