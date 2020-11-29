package com.example.lab4_modify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HorseRace extends AppCompatActivity {

    DatabaseHelper databaseHelper=new DatabaseHelper(HorseRace.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race);
        List<Horse> insertList;
        insertList=databaseHelper.getHorsesFromHorseTable();
        ArrayAdapter<Horse> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, insertList);
        ListView listHorses=findViewById(R.id.list_horses);
        listHorses.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                Intent intent=new Intent(HorseRace.this,HorseActivity.class);
                intent.putExtra(HorseActivity.EXTRA_HORSEID,(int)id);
                startActivity(intent);
            }
        };
        listHorses.setOnItemClickListener(itemClickListener);
       // Toolbar toolbar=findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
    }
}
