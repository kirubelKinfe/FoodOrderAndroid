package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.Interfaces.CategoryInterface;
import com.example.foodorderapp.Models.CategoryModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    ArrayList<CategoryModel> arrayList;
    Context context;
    CategoryInterface categoryInterface;

    public CategoryAdapter(ArrayList<CategoryModel> arrayList, Context context, CategoryInterface categoryInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.categoryInterface = categoryInterface;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new CategoryHolder(view, categoryInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.title.setText(arrayList.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0:
                picUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                break;
            case 1:
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                break;
            case 2:
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                break;
            case 3:
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                break;
            case 4:
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
                break;
        }

        holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",holder.itemView.getContext().getPackageName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        ConstraintLayout mainLayout;
        public CategoryHolder(@NonNull View itemView, CategoryInterface categoryInterface) {
            super(itemView);
            image = itemView.findViewById(R.id.popularImage);
            title = itemView.findViewById(R.id.popularFee);
            mainLayout = itemView.findViewById(R.id.popLayout);

            itemView.setOnClickListener(view -> {
                if(categoryInterface != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        categoryInterface.onCategoryItemClicked(position);
                    }
                }
            });
        }
    }
}
