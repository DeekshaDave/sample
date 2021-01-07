package com.example.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.MedicineActivity;
import com.example.finalproject.R;
import com.example.finalproject.ShowMedLogsActivity;
import com.example.finalproject.database.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.NoteViewHolder> {
    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView nameTextView;

        public NoteViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.med_row);
            this.nameTextView = view.findViewById(R.id.med_row_name);

            this.containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Medicine med = (Medicine) containerView.getTag();
                    Intent intent = new Intent(v.getContext(), ShowMedLogsActivity.class);
                    Log.d("meddd","id "+med.id);
                    intent.putExtra("id", med.id + "");
                    intent.putExtra("name", med.name);
                    intent.putExtra("dose", med.dose);

                    context.startActivity(intent);
                }
            });
        }
    }

    private List<Medicine> notes = new ArrayList<>();

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_med, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Medicine current = notes.get(position);
        holder.containerView.setTag(current);
        holder.nameTextView.setText(current.name);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void reload() {
        notes = MedicineActivity.database.medDao().getMedList();
        notifyDataSetChanged();
    }
}
