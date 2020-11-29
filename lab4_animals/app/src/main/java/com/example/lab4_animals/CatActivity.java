package com.example.lab4_animals;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CatActivity extends AppCompatActivity {
    public static final String EXTRA_CATID="catId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cat);
        int cakeId=(Integer)getIntent().getExtras().get(EXTRA_CATID);
        Cat cat=Cat.cats[cakeId];

        TextView name=findViewById(R.id.catName);
        name.setText(cat.getName());

        TextView description=findViewById(R.id.catDescription);
        description.setText(cat.getDescription());

        ImageView photo=findViewById(R.id.catPhoto);
        photo.setImageResource(cat.getImageResourceId());
        photo.setContentDescription(cat.getName());
       // Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
}