package com.example.foodorderapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderapp.R;

public class DetailsActivity extends AppCompatActivity {

    TextView titleTv, feeTv, descriptionTv, noInCartTv, addToCartBtn;
    ImageView picImage, incrementBtn, decrementBtn;

    int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        picImage = findViewById(R.id.picImage);
        titleTv = findViewById(R.id.titleTextView);
        feeTv = findViewById(R.id.feeTextView);
        descriptionTv = findViewById(R.id.descriptionTextView);
        noInCartTv = findViewById(R.id.quantityTextView);

        int img = getIntent().getIntExtra("image", 0);
        String title = getIntent().getStringExtra("title");
        String price = "$" + getIntent().getDoubleExtra("fee",0);
        String description = getIntent().getStringExtra("description");

        picImage.setImageResource(img);
        titleTv.setText(title);
        feeTv.setText(price);
        descriptionTv.setText(description);
        noInCartTv.setText(String.valueOf(numberOrder));

        incrementBtn = findViewById(R.id.incrementBtn);
        decrementBtn = findViewById(R.id.decrementBtn);
        addToCartBtn = findViewById(R.id.addToCartBtn);

        incrementBtn.setOnClickListener(view -> {
            numberOrder = numberOrder + 1;
            noInCartTv.setText(String.valueOf(numberOrder));
        });

        decrementBtn.setOnClickListener(view -> {
            if(numberOrder > 1) {
                numberOrder = numberOrder - 1;
            }
            noInCartTv.setText(String.valueOf(numberOrder));
        });



    }
}