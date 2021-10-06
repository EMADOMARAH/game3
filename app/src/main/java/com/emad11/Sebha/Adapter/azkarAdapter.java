package com.emad11.Sebha.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emad11.Sebha.azkardetails;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.emad11.Sebha.R;
import com.emad11.Sebha.Model.azkarModel;

import java.util.List;

public class azkarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE= 1;
    private final Context context;
    private final List<Object> ListRecyclerItem;

    public azkarAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        ListRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView count;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.azkartitle);
            count = itemView.findViewById(R.id.count);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType)
        {
            case TYPE :

            default:
                View layoutView = (LayoutInflater.from(parent.getContext()).inflate(R.layout.azkaritem,parent,false));

                return new azkarAdapter.ItemViewHolder(layoutView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType= getItemViewType(position);
        switch (viewType){
            case TYPE :
            default:
                ItemViewHolder itemViewHolder = (azkarAdapter.ItemViewHolder) holder;
                azkarModel azkarModel= (com.emad11.Sebha.Model.azkarModel) ListRecyclerItem.get(position);
                itemViewHolder.title.setText(azkarModel.getTitle());
                itemViewHolder.count.setText("عدد الاذكار : "+azkarModel.getCount());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context , azkardetails.class);
                        //intent.putExtra("title", itemViewHolder.title.getText());
                        intent.putExtra("pos",position);
                        context.startActivity(intent);
                    }
                });

        }
    }

    @Override
    public int getItemCount() {
        return ListRecyclerItem.size();
    }
}
