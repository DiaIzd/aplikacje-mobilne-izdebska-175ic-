package com.example.lab4_modify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DogRace extends AppCompatActivity {
    DatabaseHelper databaseHelper=new DatabaseHelper(DogRace.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_race);
        List<Cat> insertList;
        insertList=databaseHelper.getCatFromCatTable();
        ArrayAdapter<Cat> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, insertList);

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
