package com.example.kotin_roomdatabase_mvvm.data

import android.content.Context
import android.content.Entity
import android.provider.ContactsContract
import androidx.room.Room
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io

class DataManager constructor(context: Context){

    val dataBase = Room.databaseBuilder(context , DataBase::class.java , "userinfo.db").allowMainThreadQueries().build()

    fun addToDb(entity: DataEntity) {
        dataBase.getDao().insertData(entity)
    }

    fun getAllDbData(){
        dataBase.getDao()
            .getAllData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io())
            .subscribe{
                for (i in it){
                    println("Data Name : ${i.userName} Pass : ${i.userPass}")
                }
            }
    }

    fun isInDataBase(password : String) : Boolean{
        if(dataBase.getDao().isRowIsExist(password)) return true
        else return false
    }
}
