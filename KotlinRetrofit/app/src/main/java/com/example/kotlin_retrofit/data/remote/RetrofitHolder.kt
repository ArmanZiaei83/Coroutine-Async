package com.example.kotlin_retrofit.data.remote

import com.example.kotlin_retrofit.data.Api.Api
import com.example.kotlin_retrofit.data.DataManager
import com.google.android.exoplayer2.metadata.id3.ApicFrame
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHolder : DataManager {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitApi() : Api{

        var api : Api = retrofit.create(Api::class.java)

        if (api.equals(null)) onError("Error In Api")
        else onSuccess("Api Successfully")

        return api
    }

    override fun onSuccess(message: String) {
        println(message)
    }

    override fun onError(error: String) {
        println(error)
    }

}