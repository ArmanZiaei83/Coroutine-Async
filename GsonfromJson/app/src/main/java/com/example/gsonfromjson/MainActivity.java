package com.example.gsonfromjson;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.GestureOverlayView;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.text.AttributedString;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        String json = "{\"name\": \"Arman\", \"lName\" : \"Ziaei\" , \"age\" : 17 , \"job\" : \"Student\" }";
        Users users = gson.fromJson(json , Users.class);
    }
}