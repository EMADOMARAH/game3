package com.emad11.Sebha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.emad11.Sebha.Model.azkarDModel;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emad11.Sebha.R;

import java.util.List;

public class azkarDAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private final Context context;
    private final List<Object> ListRecyclerItem;

    public azkarDAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        ListRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private TextView src;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.azkardtxt);
            src = itemView.findViewById(R.id.azkardsrc);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = (LayoutInflater.from(parent.getContext()).inflate(R.layout.azkerditem,parent,false));

        return new azkarDAdapter.ItemViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemViewHolder itemViewHolder = (azkarDAdapter.ItemViewHolder) holder;
        azkarDModel azkarDModel = (com.emad11.Sebha.Model.azkarDModel) ListRecyclerItem.get(position);
        itemViewHolder.text.setText(azkarDModel.getText());
        itemViewHolder.src.setText(azkarDModel.getSource());
    }

    @Override
    public int getItemCount() {
        return ListRecyclerItem.size();
    }
}
