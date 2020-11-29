package com.example.lab4_animals;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HorseActivity extends AppCompatActivity {
    public static final String EXTRA_HORSEID="horseId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_horse);
        int cakeId=(Integer)getIntent().getExtras().get(EXTRA_HORSEID);
        Horse horse=Horse.horses[cakeId];

        TextView name=findViewById(R.id.horseName);
        name.setText(horse.getName());

        TextView description=findViewById(R.id.horseDescription);
        description.setText(horse.getDescription());

        ImageView photo=findViewById(R.id.horsePhoto);
        photo.setImageResource(horse.getImageResourceId());
        photo.setContentDescription(horse.getName());
        // Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
}

