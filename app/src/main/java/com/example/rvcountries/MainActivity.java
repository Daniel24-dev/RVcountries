package com.example.rvcountries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewContinents;
    private ContinentsAdapter continentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewContinents = findViewById(R.id.recyclerViewContinents);
        recyclerViewContinents.setLayoutManager(new LinearLayoutManager(this));

        List<String> continents = new ArrayList<>();
        continents.add("Евразия");
        continents.add("Африка");
        continents.add("Америка");
        continents.add("Австралия");
        continents.add("Антарктида");

        continentsAdapter = new ContinentsAdapter(continents, continent -> {

            Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
            intent.putExtra("continent", continent);
            startActivity(intent);
        });

        recyclerViewContinents.setAdapter(continentsAdapter);
    }
}
