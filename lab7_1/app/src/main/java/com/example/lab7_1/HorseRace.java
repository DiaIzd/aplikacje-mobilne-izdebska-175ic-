package com.example.lab7_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HorseRace extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race);

        ArrayAdapter<Horse> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Horse.horses);
        ListView listHorses = findViewById(R.id.list_horses);
        listHorses.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listHorse, View itemView, int position, long id) {
                Intent intent = new Intent(HorseRace.this, HorseActivity.class);
                intent.putExtra(HorseActivity.EXTRA_HORSEID, (int) id);
                startActivity(intent);
            }
        };
        listHorses.setOnItemClickListener(itemClickListener);
        // Toolbar toolbar=findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
    }
}