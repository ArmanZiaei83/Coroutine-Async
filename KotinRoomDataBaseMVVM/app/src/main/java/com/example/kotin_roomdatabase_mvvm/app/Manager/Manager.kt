package com.example.kotin_roomdatabase_mvvm.app.Manager

interface Manager {

    interface View{
        fun onSuccess(message : String)
        fun onError(error : String)
    }

    interface ViewModel{
        fun isInDataBaseOrNot(password: String, name : String)
        fun injectData(name : String , password : String)
    }

}