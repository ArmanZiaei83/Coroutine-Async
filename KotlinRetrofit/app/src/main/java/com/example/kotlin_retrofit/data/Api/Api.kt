package com.example.kotlin_retrofit.data.Api

import com.example.kotlin_retrofit.data.entity.RetModel
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getAllData() : Observable<List<RetModel>>
}