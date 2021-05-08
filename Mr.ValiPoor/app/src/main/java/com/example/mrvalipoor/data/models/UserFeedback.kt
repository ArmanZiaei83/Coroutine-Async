package com.example.mrvalipoor.data.models

import java.util.*

class UserFeedback(phone : String, title : String , date: String , email : String) {

    var feedbackPhone = phone
    var fTitle = title
    val fDate = date
    val fEmail = email

    //getters :

    fun getPhoneNumber() : String {
        return feedbackPhone
    }

    @JvmName("getFTitle1")
    fun getFTitle() : String{
        return fTitle
    }

    fun getDate() : String {
        return fDate
    }

    fun getEmail() : String {
        return fEmail
    }
 }