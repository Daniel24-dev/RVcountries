package com.example.rvcountries;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private List<String> countries;
    private OnItemClickListener listener;

    public CountriesAdapter(List<String> countries, OnItemClickListener listener) {
        this.countries = countries;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(String country);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String country = countries.get(position);
        holder.textView.setText(country);


        holder.itemView.setOnClickListener(v -> listener.onItemClick(country));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
