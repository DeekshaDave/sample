package com.example.finalproject.database;



import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface MedDao {

    @Query("INSERT INTO medicine (name, dose) VALUES (:medName, :dose)")
    void create(String medName , String dose);

    @Query("UPDATE medicine SET name = :medName, dose = :dose WHERE id = :id")
    void save(String medName, String dose, int id);

    @Query("DELETE FROM medicine WHERE id = :id")
    void deleteContent(int id);

    @Query("SELECT * FROM medicine")
    List<Medicine> getMedList();

}
