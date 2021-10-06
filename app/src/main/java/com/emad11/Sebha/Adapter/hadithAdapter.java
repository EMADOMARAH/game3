package com.emad11.Sebha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emad11.Sebha.R;
import com.emad11.Sebha.Model.hadithModel;

import java.util.List;

public class hadithAdapter extends RecyclerView.Adapter<hadithAdapter.hadithViewHolder> {

    private static final int TYPE= 1;
    private final Context context;
    private final List<Object> ListRecyclerItem;

    public hadithAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        ListRecyclerItem = listRecyclerItem;
    }

    @NonNull
    @Override
    public hadithViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    switch(viewType)
        {
            case TYPE :

            default:
                return new hadithViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hadithitem,parent,false));

        }
            }

    @Override
    public void onBindViewHolder(@NonNull hadithViewHolder holder, int position) {
        int viewType= getItemViewType(position);
        switch (viewType){
            case TYPE :
            default:
                hadithViewHolder hadithViewHolder = (hadithAdapter.hadithViewHolder) holder;
                hadithModel hadithModel =(com.emad11.Sebha.Model.hadithModel)ListRecyclerItem.get(position);
                hadithViewHolder.hadithtxt.setText(hadithModel.getText());
                hadithViewHolder.hadithDaraga.setText(hadithModel.getDaraga());
                hadithViewHolder.hadithSource.setText(hadithModel.getSource());

        }
    }

    @Override
    public int getItemCount() {
        return ListRecyclerItem.size();
    }

    public class hadithViewHolder extends RecyclerView.ViewHolder {
        TextView hadithtxt;
        TextView hadithDaraga;
        TextView hadithSource;
        public hadithViewHolder(@NonNull View itemView) {
            super(itemView);
            hadithtxt = itemView.findViewById(R.id.hadithtxt);
            hadithDaraga = itemView.findViewById(R.id.hadithdarga);
            hadithSource = itemView.findViewById(R.id.hadithsource);
        }
    }
}
