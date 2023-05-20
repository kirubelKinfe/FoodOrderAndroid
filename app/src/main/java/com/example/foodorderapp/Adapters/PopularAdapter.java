package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.Interfaces.CategoryInterface;
import com.example.foodorderapp.Interfaces.PopularInterface;
import com.example.foodorderapp.Models.PopularModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularHolder> {
    ArrayList<PopularModel> arrayList;
    Context context;
    PopularInterface popularInterface;

    public PopularAdapter(ArrayList<PopularModel> arrayList, Context context, PopularInterface categoryInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.popularInterface = categoryInterface;
    }

    @NonNull
    @Override
    public PopularAdapter.PopularHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_item,parent,false);
        return new PopularHolder(view, popularInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.PopularHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.fee.setText("" + arrayList.get(position).getFee());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class PopularHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView fee;
        public PopularHolder(@NonNull View itemView, PopularInterface popularInterface) {
            super(itemView);
            image = itemView.findViewById(R.id.popularImage);
            title = itemView.findViewById(R.id.popularTitle);
            fee = itemView.findViewById(R.id.popularFee);

            itemView.setOnClickListener(view -> {
                if(popularInterface != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        popularInterface.onPopularItemClicked(position);
                    }
                }
            });
        }
    }
}
