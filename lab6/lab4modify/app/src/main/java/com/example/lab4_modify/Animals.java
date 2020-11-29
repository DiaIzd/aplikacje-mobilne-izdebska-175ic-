package com.example.lab4_modify;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



public class Animals extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menumain,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_info:
                Intent intent=new Intent(this,Info.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(Animals.this,DogRace.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Animals.this,CatRace.class);
                    startActivity(intent);
                }
                if(position==0)
                {
                    Intent intent=new Intent(Animals.this,HorseRace.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView=findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
      //  Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }



}

