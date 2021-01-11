package com.example.commonapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.example.commonapp.controllers.GarageController;
import com.example.commonapp.controllers.ScreenTimeManager;
import com.example.commonapp.entities.Garage;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class CommonActivity extends AppCompatActivity {
    private long startTimeStamp = 0;
    private ScreenTimeManager screenTimeManager;
    public static int BG_COLOR = Color.WHITE;
    private TextView main_LBL_title, main_LBL_isOpen, main_LBL_adress, main_LBL_cars, main_LBL_time;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        RelativeLayout bg = (RelativeLayout) findViewById(R.id.main_common);
        bg.setBackgroundColor(BG_COLOR);

        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_LBL_isOpen = findViewById(R.id.main_LBL_isOpen);
        main_LBL_adress = findViewById(R.id.main_LBL_adress);
        main_LBL_cars = findViewById(R.id.main_LBL_cars);
        main_LBL_time = findViewById(R.id.main_LBL_time);

        screenTimeManager = ScreenTimeManager.initHelper(this.getApplicationContext());
        downloadGarage(garage -> {
            main_LBL_title.setText("Garage Name: " + garage.getName());
            String status = garage.isOpen() ? "Open" : "Close";
            main_LBL_isOpen.setText("Status: " + status);
            main_LBL_adress.setText("Address: " + garage.getAddress());
            for (String car : garage.getCars()) {
                String txt = main_LBL_cars.getText().toString();
                txt += "\n" + car;
                main_LBL_cars.setText(txt);
            }
        });
    }

    public interface CallBack_OnGarageDownloaded {
        void dataReady(Garage garage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimeStamp = System.currentTimeMillis();
        getTotalScreenTime();
    }

    @Override
    protected void onPause() {
        super.onPause();
        long duration = (System.currentTimeMillis() - startTimeStamp) / 1000;
        screenTimeManager.saveScreenTime(duration, "temp");
    }

    private void downloadGarage(CommonActivity.CallBack_OnGarageDownloaded callBack) {
        new GarageController().fetchAllGarage(garage -> {
            if (callBack != null)
                callBack.dataReady(garage);
        });
    }

    private void getTotalScreenTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                screenTimeManager.getInstance().getTotalScreenTime("temp", time -> runOnUiThread(() -> {
                    if (time >= 60) {
                        long minTime = time / 60;
                        long secTime = time % 60;
                        main_LBL_time.setText("Total Screen time \n" + minTime + " Minutes \n" + secTime + " Seconds");
                    } else
                        main_LBL_time.setText("Total Screen time " + time + " Seconds");
                }));
            }
        }).start();
    }
}