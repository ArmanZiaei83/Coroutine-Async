package com.example.ontouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public ConstraintLayout consLayout ;
    public TextView txtv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtv = (TextView) findViewById(R.id.txt_1);
        consLayout = (ConstraintLayout) findViewById(R.id.consLayout);
        consLayout.setOnTouchListener(this);
        txtv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX() ;
        float y = event.getY() ;
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            txtv.setX(x);
            txtv.setY(y);
            txtv.setBackgroundColor(Color.GREEN);
        }
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            txtv.setX(x);
            txtv.setY(y);
            txtv.setBackgroundColor(Color.BLACK);
        }
//        if (event.getAction() == MotionEvent.ACTION_UP){
//            txtv.setX(x);
//            txtv.setY(y);
//            txtv.setBackgroundColor(Color.RED);
//        }
        return  true ;
    }
}