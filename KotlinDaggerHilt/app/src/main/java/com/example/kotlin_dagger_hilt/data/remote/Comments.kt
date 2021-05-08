package com.example.kotlin_dagger_hilt.data.remote


class Comments() {

    val postId: Int = 0
    val id: Int = 0
    val name : String = ""
    val email : String = ""
    val body : String = ""

    fun getpostId() : Int {
        return postId
    }
    fun getuserId() : Int {
        return id
    }
    fun getCommentName () : String {
        return name
    }
    fun get() : String {
        return email
    }
    fun getCommentBody() : String {
        return body
    }
}
