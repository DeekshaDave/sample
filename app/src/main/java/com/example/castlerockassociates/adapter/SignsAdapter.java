package com.example.castlerockassociates.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.castlerockassociates.R;
import com.example.castlerockassociates.constants.AppConstants;
import com.example.castlerockassociates.model.SignsData;

import java.util.List;

public class SignsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private View.OnClickListener clickListener;
    private List<SignsData> signsDataList;

    public SignsAdapter (Context context, List<SignsData> data, View.OnClickListener listener) {
        mContext = context;
        clickListener = listener;
        signsDataList = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_list, parent, false);
        return new SignsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SignsHolder)holder).setData(position);
    }

    @Override
    public int getItemCount() {
        return signsDataList.size();
    }

    private class SignsHolder extends RecyclerView.ViewHolder {

        private TextView txt_name;

        public SignsHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name);
        }

        private void setData(int pos) {

            txt_name.setTag(pos);
            txt_name.setOnClickListener(clickListener);
            txt_name.setText(signsDataList.get(pos).getName());

            if (signsDataList.get(pos).getStatus().equalsIgnoreCase(AppConstants.DISPLAYING_MESSAGE)) {
                txt_name.setTextColor(mContext.getResources().getColor(R.color.black));
            } else {
                txt_name.setTextColor(mContext.getResources().getColor(R.color.gray));
            }
        }
    }
}
