package com.example.roooom.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface DaoClass {

    @Query("SELECT * FROM user")
    Flowable<List<User>> getAllUsers();

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);
}
