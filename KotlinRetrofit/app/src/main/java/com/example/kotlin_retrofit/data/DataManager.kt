package com.example.kotlin_retrofit.data

interface DataManager {
    fun onSuccess(message: String)
    fun onError(error : String)
}