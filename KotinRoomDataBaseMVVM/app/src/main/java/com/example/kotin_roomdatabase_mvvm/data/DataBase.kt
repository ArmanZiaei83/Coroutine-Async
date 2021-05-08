package com.example.kotin_roomdatabase_mvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DataEntity::class) , version = 1)
abstract class DataBase : RoomDatabase(){

    abstract fun getDao() : DataDao
}