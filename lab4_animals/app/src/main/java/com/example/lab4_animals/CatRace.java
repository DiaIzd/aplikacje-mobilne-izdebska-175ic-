package com.example.lab4_animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CatRace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_race)   ;

        ArrayAdapter<Cat> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Cat.cats);
        ListView listCats=findViewById(R.id.list_cats);
        listCats.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listCakes, View itemView, int position, long id) {
                Intent intent=new Intent(CatRace.this,CatActivity.class);
                intent.putExtra(CatActivity.EXTRA_CATID,(int)id);
                startActivity(intent);
            }
        };
        listCats.setOnItemClickListener(itemClickListener);
       // Toolbar toolbar=findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
    }
}
