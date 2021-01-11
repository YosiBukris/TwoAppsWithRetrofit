package com.example.garageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.commonapp.CommonActivity;

public class GarageActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BG_COLOR = Color.BLUE;
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_garage);
    }
}