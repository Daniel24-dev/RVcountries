package com.example.rvcountries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsAdapter.ViewHolder> {

    private List<String> continents;
    private OnItemClickListener listener;

    public ContinentsAdapter(List<String> continents, OnItemClickListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(String continent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String continent = continents.get(position);
        holder.textView.setText(continent);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(continent));
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }
}

