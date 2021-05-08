package com.example.kotlin_retrofit.data.entity

class RetModel {

    var userId : Int
    var id : Int
    lateinit var title : String
    lateinit var body : String

    fun getDataTitle() : String {
        return title
    }

    fun getDataUserId() : Int {
        return userId
    }

    fun getDataId() : Int {
        return id
    }

    fun getDataBody() : String{
        return body
    }

    fun setDataTitle(title : String){
        this.title = title
    }

    fun setDataBody(body : String){
        this.body = body
    }

    fun setDataUserId(userId: Int){
        this.userId = userId
    }

    fun setDataId(id: Int){
        this.id = id
    }

    constructor(userId: Int , id: Int, title: String, body: String) {
        this.userId = userId
        this.id = id
        this.title = title
        this.body = body
    }
}