package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.adapter.MedAdapter;
import com.example.finalproject.adapter.MedLogAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShowMedLogsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MedLogAdapter adapter;
    private TextView txt_done;
    private int col = 0;
    int id = 0;
    private List<MedLogModel> medList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_med_log);
        Intent intent = getIntent();
        col = Integer.parseInt(intent.getStringExtra("dose"));
        if(intent.getStringExtra("id") != null) {
            id = Integer.parseInt(intent.getStringExtra("id"));
        }
        String name = intent.getStringExtra("name");

        Log.d("show med","here "+name +" id "+id +" col "+col);

        if (FinalProjectprefs.getMedArray(this,name+id) == null || FinalProjectprefs.getMedArray(this,name+id).size() == 0) {
            Log.d("show med", "inside "+medList.size());

            for (int i = 0; i < col; i++) {
                MedLogModel model = new MedLogModel();
                model.setDose(col);
                model.setTaken(false);
                model.setMedName(name);
                model.setId(id);
                medList.add(model);
            }

            Log.d("show med", "array size "+medList.size());

            FinalProjectprefs.setMedArray(this,medList, name+id);
        } else{
            Log.d("show med", "else "+medList.size());
        }

        medList = new ArrayList<>();
        Log.d("show med", "medarray "+name+id);
        medList = FinalProjectprefs.getMedArray(this, name+id);
        Log.d("show med","after size "+medList.size());

        txt_done = findViewById(R.id.txt_done);

        int count = 0;
        for (int i = 0; i < medList.size(); i++) {
            if (medList.get(i).isTaken()){
                count++;
            }
        }
        if (count == medList.size()) {
            txt_done.setVisibility(View.VISIBLE);
        }

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MedLogAdapter(this, medList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
