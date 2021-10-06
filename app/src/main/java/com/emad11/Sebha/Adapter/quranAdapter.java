package com.emad11.Sebha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emad11.Sebha.R;
import com.emad11.Sebha.Model.quranModel;
import com.emad11.Sebha.utils.PreferenceUtil;

import java.util.List;

public class quranAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE= 1;
    private int savedPos;
    private final Context context;
    private final List<Object> ListRecyclerItem;

    public quranAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        ListRecyclerItem = listRecyclerItem;
        savedPos = PreferenceUtil.getInstance(context).getAppPref().getInt("pos",0);
        
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView surah_number;
        private ImageView fav;
        private TextView content;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            surah_number = (TextView) itemView.findViewById(R.id.sora);
            fav = itemView.findViewById(R.id.imageView);
            content = (TextView) itemView.findViewById(R.id.qurantxt);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = (LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_item,parent,false));
        return new ItemViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        quranModel quranModel = (com.emad11.Sebha.Model.quranModel) ListRecyclerItem.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.content.setText(quranModel.getContent());
        itemViewHolder.surah_number.setText(quranModel.getSurah_number());
        
        ((ItemViewHolder) holder).fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ItemViewHolder) holder).fav.setImageResource(R.drawable.ic_fav);
                PreferenceUtil.getInstance(context).getAppPrefEditor().putInt("pos" , position).apply();
                notifyDataSetChanged();
            }
        });
        
        if (position == PreferenceUtil.getInstance(context).getAppPref().getInt("pos",0)){
            ((ItemViewHolder) holder).fav.setImageResource(R.drawable.ic_fav);
        }
        
    }

    @Override
    public int getItemCount() {
        return ListRecyclerItem.size();
    }
}
