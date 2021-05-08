package com.example.kotlin_dagger_hilt.data

import com.example.kotlin_dagger_hilt.data.remote.Api

interface OnGetData {

    fun getData() : Api
    fun successful(message : String)
    fun onError(error : String)

}