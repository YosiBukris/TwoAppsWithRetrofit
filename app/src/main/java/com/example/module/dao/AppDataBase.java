package com.example.module.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.module.entities.AppScreenTime;

@Database(entities = {AppScreenTime.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppScreenTimeDao screenTimeDao();
}
