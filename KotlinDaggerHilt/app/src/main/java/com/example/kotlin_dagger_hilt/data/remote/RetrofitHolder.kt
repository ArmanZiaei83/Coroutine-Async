package com.example.kotlin_dagger_hilt.data.remote

import com.example.kotlin_dagger_hilt.data.OnGetData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitHolder : OnGetData {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun getData(): Api {
        val api = retrofit.create(Api::class.java)

        if (api == null)  onError("Api Is Null")
        else successful("Api Is OK, Next Step >>> ")

        return api
    }

    override fun successful(message: String) {
        println(message)
    }

    override fun onError(error: String) {
        println(error)
    }

    @Inject
    constructor(){

    }
}