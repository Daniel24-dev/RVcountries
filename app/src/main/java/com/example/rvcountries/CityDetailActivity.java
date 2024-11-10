package com.example.rvcountries;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class CityDetailActivity extends AppCompatActivity {

    private ImageView cityImageView;
    private TextView cityNameTextView;
    private boolean isImageZoomed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        cityImageView = findViewById(R.id.cityImageView);
        cityNameTextView = findViewById(R.id.cityNameTextView);

        City city = (City) getIntent().getSerializableExtra("city");

        if (city != null) {
            cityNameTextView.setText(city.getName());

            Glide.with(this)
                    .load(city.getImageUrl())
                    .error(R.drawable.ic_launcher_background)
                    .into(cityImageView);

            cityImageView.setOnClickListener(v -> toggleImageSize());
        } else {
            Toast.makeText(this, "Ошибка: данные города не найдены", Toast.LENGTH_SHORT).show();
        }
    }

    private void toggleImageSize() {
        if (isImageZoomed) {
            ViewGroup.LayoutParams params = cityImageView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            cityImageView.setLayoutParams(params);
            isImageZoomed = false;
        } else {
            ViewGroup.LayoutParams params = cityImageView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            cityImageView.setLayoutParams(params);
            isImageZoomed = true;
        }
    }
}
