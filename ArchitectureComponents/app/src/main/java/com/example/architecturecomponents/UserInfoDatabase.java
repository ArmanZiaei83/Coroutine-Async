package com.example.architecturecomponents;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ConcurrentModificationException;

@Database(entities = {UserInfo.class} , version = 1)
public abstract class UserInfoDatabase extends RoomDatabase {

    public static UserInfoDatabase instance;

    public abstract UserInfoDao userInfoDao();

    public static synchronized UserInfoDatabase getInstance(Context context){

        if(instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(), UserInfoDatabase.class , "userDb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

        //Continue to the Link : https://www.youtube.com/watch?v=HhmA9S53XV8
    }

}
