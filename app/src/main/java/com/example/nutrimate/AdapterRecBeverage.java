package com.example.nutrimate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecBeverage extends RecyclerView.Adapter<AdapterRecBeverage.ViewHolder>{
    ArrayList<BeverageModel> dataMinuman;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaMinuman;
        ImageView fotoMinuman;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMinuman = itemView.findViewById(R.id.beveragename);
            fotoMinuman = itemView.findViewById(R.id.beverageimage);
        }
    }

    AdapterRecBeverage(ArrayList<BeverageModel> data) {this.dataMinuman = data;}

    @NonNull
    @Override
    public AdapterRecBeverage.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_beverage_item, parent, false);
        return new AdapterRecBeverage.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecBeverage.ViewHolder holder, int position) {
        TextView beveragename = holder.namaMinuman;
        ImageView beverageimage = holder.fotoMinuman;

        beveragename.setText(dataMinuman.get(position).getName());
        beverageimage.setImageResource(dataMinuman.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataMinuman.size();
    }
}
