package com.example.lab4_animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DogRace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_race);

        ArrayAdapter<Dog> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Dog.dogs);
        ListView listDogs=findViewById(R.id.list_dogs);
        listDogs.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                Intent intent=new Intent(DogRace.this,DogActivity.class);
                intent.putExtra(DogActivity.EXTRA_DOGID,(int)id);
                startActivity(intent);
            }
        };
        listDogs.setOnItemClickListener(itemClickListener);
        // Toolbar toolbar=findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
    }
}
