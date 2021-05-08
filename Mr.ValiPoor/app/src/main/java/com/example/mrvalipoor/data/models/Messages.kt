package com.example.mrvalipoor.data.models

class Messages(date : String , message : String , email : String, phone : String) {

    var messageDate = date
    var messageBody = message
    var userEmail = email
    var phoneNumber = phone

    fun getPhone() : String {
        return phoneNumber
    }

    fun getEmail() : String {
        return userEmail
    }

    fun getMessage() : String {
        return messageBody
    }

    fun getDate() : String {
        return messageDate
    }
}