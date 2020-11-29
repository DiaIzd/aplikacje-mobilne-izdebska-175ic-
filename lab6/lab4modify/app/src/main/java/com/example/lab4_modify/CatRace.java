package com.example.lab4_modify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CatRace extends AppCompatActivity {
    DatabaseHelper databaseHelper=new DatabaseHelper(CatRace.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_race)   ;
        List<Cat> insertList;
        insertList=databaseHelper.getCatFromCatTable();
        ArrayAdapter<Cat> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, insertList);
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
