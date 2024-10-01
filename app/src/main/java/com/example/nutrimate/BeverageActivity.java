package com.example.nutrimate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BeverageActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRecBeverage adapterRecBeverage;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BeverageModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beverage_screen);

        recyclerView = findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i=0; i<MyBeverage.nameB.length; i++){
            data.add(new BeverageModel(MyBeverage.nameB[i], MyBeverage.imageB[i]));
        }
        adapterRecBeverage = new AdapterRecBeverage(data);
        recyclerView.setAdapter(adapterRecBeverage);

    }
}
