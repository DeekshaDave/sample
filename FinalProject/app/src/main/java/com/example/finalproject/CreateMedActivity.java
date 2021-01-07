package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMedActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_med_name;
    private EditText edt_med_dose;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_med);

        edt_med_name = findViewById(R.id.edt_med_name);
        edt_med_dose = findViewById(R.id.edt_med_dose);

        Log.d("create med", "here");
        btn_save = findViewById(R.id.btn_save_med);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("create med", "on click");
                MedicineActivity.database.medDao().create(edt_med_name.getText().toString(),
                        edt_med_dose.getText().toString());
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}