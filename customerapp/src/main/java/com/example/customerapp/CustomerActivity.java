package com.example.customerapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.module.MainActivity;

import android.os.Bundle;

public class CustomerActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }
}