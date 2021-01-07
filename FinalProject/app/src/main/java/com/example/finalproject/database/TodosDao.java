package com.example.finalproject.database;

import androidx.room.Dao;
import androidx.room.Query;


@Dao
public interface TodosDao {

     @Query("INSERT INTO todos (task) VALUES (:tasks)")
     void create(String tasks);

     @Query("UPDATE todos SET task = :task WHERE id = :id")
     void save(String task, int id);

     @Query("DELETE FROM todos WHERE id = :id")
     void deleteContent(int id);

     @Query("SELECT * FROM todos")
     Todos getTodos();

}
