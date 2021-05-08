package com.example.mrvalipoor.presentation

import android.widget.ImageView
import com.example.mrvalipoor.data.models.AcceptedJobDetails

interface SetOnClick {
    fun onClick(image : ImageView)
    fun openInfoDetail(position: AcceptedJobDetails)
}