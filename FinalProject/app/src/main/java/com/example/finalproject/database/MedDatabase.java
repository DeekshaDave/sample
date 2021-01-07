package com.example.finalproject.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Medicine.class}, version = 1)
public abstract class MedDatabase extends RoomDatabase {
    public abstract MedDao medDao();
}
