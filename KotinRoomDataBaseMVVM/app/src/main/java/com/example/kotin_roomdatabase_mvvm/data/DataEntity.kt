package com.example.kotin_roomdatabase_mvvm.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class DataEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "name") val userName : String,
    @ColumnInfo(name = "password") val userPass : String
)