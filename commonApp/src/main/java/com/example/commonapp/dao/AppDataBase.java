package com.example.commonapp.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.commonapp.entities.AppScreenTime;

@Database(entities = {AppScreenTime.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppScreenTimeDao screenTimeDao();
}
