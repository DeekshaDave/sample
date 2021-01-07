package com.example.finalproject.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Todos {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "task")
    public String task;

}
