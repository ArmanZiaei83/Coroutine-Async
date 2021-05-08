package com.example.sample.automobile

import javax.inject.Inject

class Engine {

    var speed : Int
    var brand : String

    @Inject
    constructor(speed : Int , brand : String){
        this.speed = speed
        this.brand = brand
    }

    fun run(){
        println("Car is Runnig With Speed : $speed & Brand : $brand")
    }

}
