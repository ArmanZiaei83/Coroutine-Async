package com.example.gsonfromjson;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("name")
    String firstName ;
    @SerializedName("lName")
    String lastName ;
    @SerializedName("age")
    int age ;
    
    String job ;

    public void Users (String firstNAme , String lastNAme  , int Age , String Job ){
        firstName = firstNAme ;
        lastName = lastNAme ;
        age = Age ;
        job = Job ;

    }
}
