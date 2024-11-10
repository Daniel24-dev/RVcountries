package com.example.rvcountries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private List<City> cities;
    private OnCityClickListener onCityClickListener;

    public CitiesAdapter(List<City> cities, OnCityClickListener listener) {
        this.cities = cities;
        this.onCityClickListener = listener;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final City city = cities.get(position);
        holder.textView.setText(city.getName());

        holder.itemView.setOnClickListener(v -> onCityClickListener.onCityClick(city));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public interface OnCityClickListener {
        void onCityClick(City city);
    }
}
