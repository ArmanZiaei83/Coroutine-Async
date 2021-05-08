package com.example.kotin_roomdatabase_mvvm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface DataDao {

    @Query("SELECT * FROM user_info")
    fun getAllData() : Flowable<List<DataEntity>>

    @Insert
    fun insertData(entity: DataEntity)

    @Query("SELECT EXISTS(SELECT * FROM user_info WHERE password = :password)")
    fun isRowIsExist(password : String) : Boolean

    @Delete
    fun deleteData(entity: DataEntity)
}