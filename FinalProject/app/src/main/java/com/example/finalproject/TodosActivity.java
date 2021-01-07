package com.example.finalproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.finalproject.database.Todos;

public class TodosActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_todos;
    private Button btn_save;
    private Button btn_Delete;
    private Todos todos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        edt_todos = findViewById(R.id.edt_todos);

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        btn_Delete = findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(this);

        todos = LandingActivity.database.todosDao().getTodos();
        if(todos!=null){
            if(todos.task.length() >0 ){
                edt_todos.setText(todos.task);
                btn_Delete.setVisibility(View.VISIBLE);
                btn_save.setEnabled(true);
                btn_save.setBackgroundColor(ContextCompat.getColor(TodosActivity.this,android.R.color.holo_green_light));
            }
        }

        edt_todos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edt_todos.getText().toString().length() > 0) {
                    btn_save.setEnabled(true);
                    btn_save.setBackgroundColor(ContextCompat.getColor(TodosActivity.this,android.R.color.holo_green_light));
                } else {
                    btn_save.setEnabled(false);
                    btn_save.setBackgroundColor(ContextCompat.getColor(TodosActivity.this,android.R.color.holo_orange_light));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_save:
                if (btn_save.isEnabled()) {
                    if (todos != null) {
                        LandingActivity.database.todosDao().save(edt_todos.getText().toString(), todos.id);
                    } else{
                        LandingActivity.database.todosDao().create(edt_todos.getText().toString());
                    }
                    this.finish();
                }

                break;

            case R.id.btn_Delete:
                LandingActivity.database.todosDao().deleteContent(todos.id);
                this.finish();
                break;
        }
    }
}
