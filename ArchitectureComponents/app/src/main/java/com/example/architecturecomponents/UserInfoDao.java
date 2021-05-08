package com.example.architecturecomponents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserInfoDao {

    @Insert
    void insert(UserInfo userInfo);

    @Update
    void update(UserInfo userInfo);

    @Delete
    void delete(UserInfo userInfo);

    @Query("DELETE FROM user_info_table")
    void deleteAllUsersInfp();

    @Query("SELECT * FROM user_info_table ORDER BY id DESC")
    LiveData<List<UserInfo>> getAllData();
}
