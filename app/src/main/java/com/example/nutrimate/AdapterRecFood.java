package com.example.nutrimate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecFood extends RecyclerView.Adapter<AdapterRecFood.ViewHolder> {
    private ArrayList<FoodModel> dataMakanan;
    private Context context;

    public AdapterRecFood(Context context, ArrayList<FoodModel> data) {
        this.context = context;
        this.dataMakanan = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaMakanan;
        ImageView fotoMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMakanan = itemView.findViewById(R.id.foodname);
            fotoMakanan = itemView.findViewById(R.id.foodimage);
        }
    }

    @NonNull
    @Override
    public AdapterRecFood.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecFood.ViewHolder holder, int position) {
        TextView foodname = holder.namaMakanan;
        ImageView foodimage = holder.fotoMakanan;

        foodname.setText(dataMakanan.get(position).getName());
        foodimage.setImageResource(dataMakanan.get(position).getImage());

        holder.itemView.setOnClickListener(v -> {
            if (position == 0) {
                Intent intent = new Intent(context, Information.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }
}
