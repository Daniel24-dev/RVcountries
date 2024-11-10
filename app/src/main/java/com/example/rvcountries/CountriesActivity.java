package com.example.rvcountries;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCountries;
    private CountriesAdapter countriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        recyclerViewCountries = findViewById(R.id.recyclerViewCountries);
        recyclerViewCountries.setLayoutManager(new LinearLayoutManager(this));


        String continent = getIntent().getStringExtra("continent");


        List<String> countries = new ArrayList<>();
        if (continent != null) {
            switch (continent) {
                case "Евразия":
                    countries.add("Россия");
                    countries.add("Казахстан");
                    countries.add("Кыргызстан");
                    countries.add("Китай");
                    countries.add("Озбекстан");
                    break;
                case "Африка":
                    countries.add("Нигерия");
                    countries.add("Египет");
                    break;
                case "Америка":
                    countries.add("США");
                    countries.add("Мексика");
                    break;
                case "Австралия":
                    countries.add("Сидней");
                    break;


            }
        }


        countriesAdapter = new CountriesAdapter(countries, new CountriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String country) {

                Intent intent = new Intent(CountriesActivity.this, CitiesActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });

        recyclerViewCountries.setAdapter(countriesAdapter);
    }
}
