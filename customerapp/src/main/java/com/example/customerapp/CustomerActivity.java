package com.example.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.commonapp.CommonActivity;

import android.graphics.Color;
import android.os.Bundle;

public class CustomerActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BG_COLOR = Color.GREEN;
        APP_NAME = "CustomerApp";
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer);
    }
}