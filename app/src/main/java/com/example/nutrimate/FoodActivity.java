package com.example.nutrimate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRecFood adapterRecFood;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FoodModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_screen);

        recyclerView = findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i = 0; i < MyFood.nameF.length; i++) {
            data.add(new FoodModel(MyFood.nameF[i], MyFood.imageF[i]));
        }
        adapterRecFood = new AdapterRecFood(this, data);
        recyclerView.setAdapter(adapterRecFood);
    }
}
