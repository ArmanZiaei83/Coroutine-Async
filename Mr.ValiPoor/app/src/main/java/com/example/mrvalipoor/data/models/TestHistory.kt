package com.example.mrvalipoor.data.models

class TestHistory(price : Int , date : String) {

    var giftPrice = price
    var giftDate = date

    fun getPrice() : Int {
        return giftPrice
    }

    fun getDate() : String {
        return giftDate
    }

    fun setPrice(price : Int) {
        this.giftPrice = price
    }

    fun setData(date : String){
        this.giftDate = date
    }

}