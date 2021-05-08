package com.example.kotlin_corotunies_retrofit.domain

import com.example.kotlin_corotunies_retrofit.app.adapter.Adapter
import com.example.kotlin_corotunies_retrofit.data.Data
import com.example.kotlin_corotunies_retrofit.data.Pager
import com.example.kotlin_corotunies_retrofit.data.RetrofitHolder
import com.example.kotlin_corotunies_retrofit.di.DaggerRetrofitComponent
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.inject.Inject

class AccessData @Inject constructor() : OnDomainHandler{

    val component = DaggerRetrofitComponent.create()
    @Inject
    lateinit var retrofitHolder: RetrofitHolder

    val dataList = arrayListOf<Data>()

    fun getList(): ArrayList<Data> {
        return dataList
    }
    override suspend fun getData() {
        component.inject(this)
        getFPage()
        delay(3000)
        getLPage()
    }

    suspend fun getFPage(){
        retrofitHolder.getApi().getDataPage(1)
            .enqueue(object : retrofit2.Callback<Pager>{
                override fun onResponse(call: Call<Pager>, response: Response<Pager>) {
                    if (response.isSuccessful){
                        for (i in response.body()!!.getData()) {
                            dataList.add(i)
                            println("Data Avatar : ${i.getAvatar()}")
                        }
                    }
                }

                override fun onFailure(call: Call<Pager>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })
    }

    suspend fun getLPage(){
        retrofitHolder.getApi().getDataPage(2)
            .enqueue(object : retrofit2.Callback<Pager>{
                override fun onResponse(call: Call<Pager>, response: Response<Pager>) {
                    if (response.isSuccessful){
                        for (i in response.body()!!.getData()){
                            dataList.add(i)
                            println("Data Avatar : ${i.getAvatar()}")}
                    }
                }

                override fun onFailure(call: Call<Pager>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })
    }

}