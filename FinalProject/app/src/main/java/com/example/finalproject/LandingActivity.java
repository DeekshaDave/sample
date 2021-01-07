package com.example.finalproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.finalproject.database.MedDatabase;
import com.example.finalproject.database.TodosDatabase;

import java.util.Calendar;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_filter;
    private Button btn_medication;
    private Button btn_todos;
    private Button btn_mood;
    public static TodosDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        database = Room
                .databaseBuilder(getApplicationContext(), TodosDatabase.class, "todos")
                .allowMainThreadQueries()
                .build();

        btn_filter = findViewById(R.id.btn_filter);
        btn_medication = findViewById(R.id.btn_medication);
        btn_todos = findViewById(R.id.btn_todos);
        btn_mood = findViewById(R.id.btn_mood);

        btn_filter.setOnClickListener(this);
        btn_medication.setOnClickListener(this);
        btn_todos.setOnClickListener(this);
        btn_mood.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_filter:
                Intent intent = new Intent(LandingActivity.this, FilterActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_medication:
                Intent intent1 = new Intent(LandingActivity.this, MedicineActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_todos:
                Intent i = new Intent(LandingActivity.this, TodosActivity.class);
                startActivity(i);
                break;

            case R.id.btn_mood:
                Intent i1 = new Intent(LandingActivity.this, MoodActivity.class);
                startActivity(i1);
                break;
        }
    }


}
