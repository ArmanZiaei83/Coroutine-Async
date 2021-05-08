package com.example.kotlin_corotunies_retrofit.data

class Data {

    var id = 0
    var email : String = ""
    var first_name = ""
    var last_name = ""
    var avatar = ""

    @JvmName("getId1")
    fun getId() : Int {
        return id
    }

    @JvmName("getEmail1")
    fun getEmail() : String {
        return email
    }
    fun getFName() : String{
        return first_name
    }

    fun getLName() : String{
        return last_name
    }

    @JvmName("getAvatar1")
    fun getAvatar() : String{
        return avatar
    }

}
