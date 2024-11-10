package com.example.rvcountries;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity implements CitiesAdapter.OnCityClickListener {

    private RecyclerView recyclerViewCities;
    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        recyclerViewCities = findViewById(R.id.recyclerViewCities);
        recyclerViewCities.setLayoutManager(new LinearLayoutManager(this));

        String country = getIntent().getStringExtra("country");

        List<City> cities = new ArrayList<>();
        if (country != null) {
            switch (country) {
                case "Россия":
                    cities.add(new City("Москва", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Moscow_City_Sunset.jpg/2560px-Moscow_City_Sunset.jpg"));

                    cities.add(new City("Санкт-Петербург", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    break;
                case "Казахстан":
                    cities.add(new City("Алматы", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    cities.add(new City("Нур-Султан", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    break;
                case "Кыргызстан":
                    cities.add(new City("Ош", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    cities.add(new City("Бишкек", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    break;
                case "Озбекстан":
                    cities.add(new City("Ташкенд", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    cities.add(new City("Самарканд", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    break;
                case "Китай":
                    cities.add(new City("Пекин", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    cities.add(new City("Гуанджоу", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg/1200px-New_York_City_%28New_York%2C_USA%29%2C_Empire_State_Building_--_2012_--_6448.jpg"));
                    break;
            }
        }

        citiesAdapter = new CitiesAdapter(cities, this);
        recyclerViewCities.setAdapter(citiesAdapter);
    }

    @Override
    public void onCityClick(City city) {

        Intent intent = new Intent(this, CityDetailActivity.class);
        intent.putExtra("city", city);
        startActivity(intent);
    }
}
