package com.example.finalproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todos.class}, version = 1)
public abstract class TodosDatabase extends RoomDatabase {
    public abstract TodosDao todosDao();
}







