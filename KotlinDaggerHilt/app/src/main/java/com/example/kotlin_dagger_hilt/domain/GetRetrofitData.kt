package com.example.kotlin_dagger_hilt.domain

import androidx.annotation.DimenRes
import com.example.kotlin_dagger_hilt.data.remote.Comments
import com.example.kotlin_dagger_hilt.data.remote.RetrofitHolder
import com.example.kotlin_dagger_hilt.di.RetrofitComponent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject


class GetRetrofitData : OnRemote {

    @Inject
    constructor(){
    }

    lateinit var component : RetrofitComponent
    @Inject
    lateinit var retrofitHolder: RetrofitHolder

    override fun getData(): Observable<List<Comments>> {

        if (retrofitHolder == null) onErrorInGettingData("RetrofitHolder Instance Is Null")
        else onGotAllData("RetrofitHolder Is NOT Null, Results :  >>> ")

        return retrofitHolder.getData()
            .getComments()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io())

    }


    override fun onGotAllData(message: String) {
        println(message)
        getData().subscribe{
            showResults(it)
        }
    }

    private fun showResults(it: List<Comments>?) {
        if (it != null) {
            for (i in it)   println(i)
        }
    }

    override fun onErrorInGettingData(error: String) {
        println(error)
    }
}