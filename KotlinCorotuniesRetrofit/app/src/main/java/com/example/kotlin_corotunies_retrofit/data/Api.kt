package com.example.kotlin_corotunies_retrofit.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/users")
    fun getDataPage(@Query("page") id : Int) : Call<Pager>
}
