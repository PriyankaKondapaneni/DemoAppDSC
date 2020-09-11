package com.codewithsiri.demoappdsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<items> itemsList;

    public MyAdapter() {
        itemsList = new ArrayList<>();
    }

    public void setData(ArrayList<items> itemsList) {
        this.itemsList = itemsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cards_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        items items = itemsList.get(position);
        holder.events.setText(items.events);

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView events;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            events = itemView.findViewById(R.id.textView);
            cardview = itemView.findViewById(R.id.cardView);

        }
    }
}
