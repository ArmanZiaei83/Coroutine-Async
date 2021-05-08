package com.example.birdcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class ImportInfo extends AppCompatActivity {
    public EditText name ;
    public ImageView birdImage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_info);

        Intent intent = new Intent(this , IntentServices.class);
        ContextCompat.startForegroundService(this , intent);

    }
}