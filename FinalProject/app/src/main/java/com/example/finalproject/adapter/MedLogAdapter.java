package com.example.finalproject.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.FinalProjectprefs;
import com.example.finalproject.MedLogModel;
import com.example.finalproject.MedicineActivity;
import com.example.finalproject.R;
import com.example.finalproject.ShowMedLogsActivity;
import com.example.finalproject.database.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedLogAdapter extends RecyclerView.Adapter<MedLogAdapter.NoteViewHolder> {
    private Context mContext;
    private int pos;
    private List<MedLogModel> medLogs = new ArrayList<>();

    public MedLogAdapter(Context context, List<MedLogModel> list){
        mContext = context;
        medLogs = list;
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_dose;
        public NoteViewHolder(View view) {
            super(view);

            this.txt_dose = view.findViewById(R.id.txt_dose);
        }
    }



    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_med_log, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoteViewHolder holder, final int position) {
        MedLogModel current = medLogs.get(position);
        holder.txt_dose.setTag(current);
        Log.d("med adapter", "in bind "+current.isTaken());

        pos = position + 1;
        holder.txt_dose.setText("Dose " + pos);

        if (current.isTaken()) {
                holder.txt_dose.setBackgroundColor(ContextCompat.getColor(mContext,android.R.color.holo_green_dark));
                holder.txt_dose.setEnabled(false);
        }


        holder.txt_dose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txt_dose.setBackgroundColor(ContextCompat.getColor(mContext,android.R.color.holo_green_dark));
                holder.txt_dose.setEnabled(false);

                MedLogModel model = new MedLogModel();
                model = medLogs.get(position);
                model.setTaken(true);
                medLogs.set(position, model);

                Log.d("med adapter", "on click "+medLogs.size() +" pos "+position +", "+model.getMedName()+model.getId());
                FinalProjectprefs.setMedArray(mContext, medLogs, model.getMedName()+model.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("med adapter","size "+medLogs.size());
        return medLogs.size();
    }
}
