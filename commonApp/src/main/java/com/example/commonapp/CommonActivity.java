package com.example.commonapp;

import android.os.Bundle;

import com.example.commonapp.controllers.GarageController;
import com.example.commonapp.controllers.ScreenTimeManager;
import com.example.commonapp.entities.Garage;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

public abstract class CommonActivity extends AppCompatActivity {
    private long startTimeStamp = 0;
    private ScreenTimeManager screenTimeManager;

    private Button button;
    private TextView main_LBL_info;
    private TextView main_LBL_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        button = findViewById(R.id.button);
        main_LBL_info = findViewById(R.id.main_LBL_info);
        main_LBL_time = findViewById(R.id.main_LBL_time);
        screenTimeManager = ScreenTimeManager.initHelper(this.getApplicationContext());
        button.setOnClickListener(view -> downloadGarage(garage -> {
            main_LBL_info.setText("Name: " + garage.getName());
        }));
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
        long duration = (System.currentTimeMillis() - startTimeStamp)/1000;
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
                    if (time >= 60){
                        long minTime = time/60;
                        long secTime = time%60;
                        main_LBL_time.setText("Total Screen time \n" + minTime +" Minutes \n" + secTime +" Seconds");
                    }else
                        main_LBL_time.setText("Total Screen time " + time +" Seconds");
                }));
            }
        }).start();
    }
}