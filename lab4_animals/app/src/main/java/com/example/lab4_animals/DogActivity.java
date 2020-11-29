package com.example.lab4_animals;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DogActivity extends AppCompatActivity {
    public static final String EXTRA_DOGID="dogId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        int drinkId=(Integer)getIntent().getExtras().get(EXTRA_DOGID);
       Dog dog=Dog.dogs[drinkId];

        TextView name=findViewById(R.id.dogName);
        name.setText(dog.getName());

        TextView description=findViewById(R.id.dogDescription);
        description.setText(dog.getDescription());

        ImageView photo=findViewById(R.id.dogPhoto);
        photo.setImageResource(dog.getImageResourceId());
        photo.setContentDescription(dog.getName());
       // Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

}
