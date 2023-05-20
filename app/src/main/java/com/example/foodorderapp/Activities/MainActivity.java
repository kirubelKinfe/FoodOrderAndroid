package com.example.foodorderapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderapp.Adapters.CategoryAdapter;
import com.example.foodorderapp.Adapters.PopularAdapter;
import com.example.foodorderapp.Interfaces.CategoryInterface;
import com.example.foodorderapp.Interfaces.PopularInterface;
import com.example.foodorderapp.Models.CategoryModel;
import com.example.foodorderapp.Models.PopularModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryInterface, PopularInterface {

    ArrayList<CategoryModel> categoryList = new ArrayList<>();
    RecyclerView categoryView;
    CategoryAdapter categoryAdapter;
    ArrayList<PopularModel> popularList = new ArrayList<>();
    RecyclerView popularView;
    PopularAdapter popularAdapter;

    int[] categoryImage = {
            R.drawable.cat_1,
            R.drawable.cat_2,
            R.drawable.cat_3,
            R.drawable.cat_4,
            R.drawable.cat_5,
    };
    int[] popularImage = {
            R.drawable.pop_1,
            R.drawable.pop_2,
            R.drawable.pop_3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpCategories();
        categoryView = findViewById(R.id.categoryRecyclerView);
        categoryAdapter = new CategoryAdapter(categoryList, this, this);
        categoryView.setAdapter(categoryAdapter);
        categoryView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        setUpPopulars();
        popularView = findViewById(R.id.popularRecyclerView);
        popularAdapter = new PopularAdapter(popularList, this, this);
        popularView.setAdapter(popularAdapter);
        popularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    private void setUpCategories() {
        categoryList.add(new CategoryModel(categoryImage[0], "Pizza"));
        categoryList.add(new CategoryModel(categoryImage[1], "Burger"));
        categoryList.add(new CategoryModel(categoryImage[2], "HotDog"));
        categoryList.add(new CategoryModel(categoryImage[3], "Drink"));
        categoryList.add(new CategoryModel(categoryImage[4], "Pie"));

    }

    private void setUpPopulars() {
        popularList.add(new PopularModel(popularImage[0], "Pizza","This is a great pizza",9.99, 0));
        popularList.add(new PopularModel(popularImage[1], "Burgers","This is a great burgers",10.24, 0));
        popularList.add(new PopularModel(popularImage[2], "Pizza","This is a great pizza",5.49, 0));
    }

    @Override
    public void onCategoryItemClicked(int position) {
        Toast.makeText(this, categoryList.get(position).getTitle() + " Selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPopularItemClicked(int position) {
        Toast.makeText(this, popularList.get(position).getTitle() + " Selected", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("image", popularList.get(position).getImage());
        intent.putExtra("title", popularList.get(position).getTitle());
        intent.putExtra("fee", popularList.get(position).getFee());
        intent.putExtra("description", popularList.get(position).getDescription());
        startActivity(intent);
    }
}