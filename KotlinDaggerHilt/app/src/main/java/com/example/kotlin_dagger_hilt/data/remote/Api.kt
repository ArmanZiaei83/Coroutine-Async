package com.example.kotlin_dagger_hilt.data.remote

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getComments() : Observable<List<Comments>>
}