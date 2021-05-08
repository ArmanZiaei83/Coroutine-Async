package com.example.birdcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button btnImportInfo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnImportInfo = (Button) findViewById(R.id.btnToImport);

        btnImportInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toImport = new Intent(MainPage.this , ImportInfo.class);
                startActivity(toImport);
            }
        });
    }
}