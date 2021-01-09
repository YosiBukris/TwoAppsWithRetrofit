package com.example.module;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String link = "https://pastebin.com/raw/";
    private Button button;
    private TextView main_LBL_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        main_LBL_info = findViewById(R.id.main_LBL_info);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadGarages();
            }
        });
    }

    private void downloadGarages() {
        new GarageController().fetchAllGarage(new GarageController.CallBack_Garage() {
            @Override
            public void garage(Garage garage) {
                main_LBL_info.setText("Garage Name = " + garage.getName());
            }
        });
    }
}