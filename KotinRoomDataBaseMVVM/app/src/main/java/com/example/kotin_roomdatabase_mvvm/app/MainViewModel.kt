package com.example.kotin_roomdatabase_mvvm.app

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kotin_roomdatabase_mvvm.app.Manager.Manager
import com.example.kotin_roomdatabase_mvvm.data.DataEntity
import com.example.kotin_roomdatabase_mvvm.data.DataManager

class MainViewModel : ViewModel(), Manager.ViewModel {

    lateinit var dataEntity: DataEntity
    lateinit var context: Context
    lateinit var dataManager: DataManager

    fun setContextDataBase(context: Context){
        this.context = context
        dataManager = DataManager(context)
    }

    override fun isInDataBaseOrNot(password: String , name : String) {
        if (dataManager.isInDataBase(password)){
            println("Data Is In DataBase")
        }else{
            injectData(name , password)
            println("Data Injected In Room Data Base")
        }
    }

    override fun injectData(name: String, password: String) {
        dataEntity = DataEntity(0, name , password)
        dataManager.addToDb(dataEntity)
    }

    fun getAllData(){
        dataManager.getAllDbData()
    }
}