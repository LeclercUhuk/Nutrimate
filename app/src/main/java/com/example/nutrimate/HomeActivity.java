package com.example.nutrimate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {
    private CardView card_food;
    private CardView card_beverage;
    private CardView card_recipe;
    private CardView card_calculate;
    private ImageButton profile_icon;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        card_food = findViewById(R.id.cardFood);
        card_beverage = findViewById(R.id.cardBeverage);
        card_recipe = findViewById(R.id.cardRecipe);
        card_calculate = findViewById(R.id.cardCalculate);
        profile_icon = findViewById(R.id.profileButton);
        String email = getIntent().getStringExtra("email");

        // Untuk pindah ke FoodActivity
        card_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        // Untuk pindah ke BeverageActivity
        card_beverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BeverageActivity.class);
                startActivity(intent);
            }
        });

        // Untuk pindah ke RecipeActivity
        card_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "You are not yet registered as Premium member", Toast.LENGTH_SHORT).show();
            }
        });

        // Untuk pindah ke CalculateActivity
        card_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "You are not yet registered as Premium member", Toast.LENGTH_SHORT).show();
            }
        });

        // Untuk pindah ke profile
        profile_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

    }
}
