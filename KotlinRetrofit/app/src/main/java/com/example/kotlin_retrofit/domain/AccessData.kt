package com.example.kotlin_retrofit.domain

import com.example.kotlin_retrofit.data.entity.RetModel
import com.example.kotlin_retrofit.data.remote.RetrofitHolder
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io

class AccessData {

    fun getRetrofitData() : Observable<List<RetModel>>{
        return RetrofitHolder().getRetrofitApi()
            .getAllData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io())
    }
}