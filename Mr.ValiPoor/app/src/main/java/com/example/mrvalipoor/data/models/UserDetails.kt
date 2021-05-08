package com.example.mrvalipoor.data.models

class UserDetails(state: String, city: String, neighbor: String, phoneNumber: String) {

    var userState = state
    var userCity = city
    var userNeighbor = neighbor
    var userPhoneNumber = phoneNumber
    var isExpand = false

    fun getIsExpand() : Boolean{
        return isExpand
    }

    @JvmName("getUserState1")
    fun getUserState() : String {
        return userState
    }

    @JvmName("getUserCity1")
    fun getUserCity() : String {
        return userCity
    }

    @JvmName("getUserNeighbor1")
    fun getUserNeighbor() : String {
        return userNeighbor
    }

    @JvmName("getUserPhoneNumber1")
    fun getUserPhoneNumber() : String {
        return userPhoneNumber
    }

}