package com.example.sample.automobile

import android.speech.tts.TextToSpeech
import javax.inject.Inject

class Car {

    lateinit var engine : Engine

    @Inject
    constructor(engine : Engine){
        this.engine = engine
    }
}