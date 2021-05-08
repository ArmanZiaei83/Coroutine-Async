package com.example.kotlin_dagger_hilt.domain

import com.example.kotlin_dagger_hilt.data.remote.Comments
import io.reactivex.Observable
import org.w3c.dom.Comment

interface OnRemote {
    fun getData() : Observable<List<Comments>>
    fun onGotAllData(message : String)
    fun onErrorInGettingData(error : String)
}