package com.example.rvcountries;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCities;
    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        recyclerViewCities = findViewById(R.id.recyclerViewCities);
        recyclerViewCities.setLayoutManager(new LinearLayoutManager(this));

        String country = getIntent().getStringExtra("country");

        List<String> cities = new ArrayList<>();
        if (country != null) {
            switch (country) {
                case "Россия":
                    cities.add("Москва");
                    cities.add("Санкт-Петербург");
                    break;
                case "Казахстан":
                    cities.add("Алматы");
                    cities.add("Нур-Султан");

                    break;
                case "Кыргызстан":
                    cities.add("Ош");
                    cities.add("Бишкек");
                    break;
                case "Озбекстан":
                    cities.add("Ташкенд");
                    cities.add("Самарканд");
                    break;
                case "Китай":
                    cities.add("Пекин");
                    cities.add("Гуанджоу");
                    break;

            }
        }

        citiesAdapter = new CitiesAdapter(cities);
        recyclerViewCities.setAdapter(citiesAdapter);
    }
}
