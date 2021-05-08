package com.example.kotlin_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_retrofit.domain.AccessData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers.io

class MainViewModel : ViewModel() {

    val accessor = AccessData()

    fun setAdapter(adapter : RecyclerViewAdapter, recyclerView : RecyclerView) : RecyclerViewAdapter{
        accessor.getRetrofitData().flatMap { t ->
            adapter.setList(t)
            recyclerView.adapter = adapter
            Observable.fromIterable(t).subscribeOn(io())
        }.subscribe()

        return adapter
    }
}

