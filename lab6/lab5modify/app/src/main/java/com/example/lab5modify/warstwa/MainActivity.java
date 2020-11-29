package com.example.lab5modify.warstwa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.lab5modify.R;
import com.example.lab5modify.warstwa1.CatListActivity;
import com.example.lab5modify.warstwa1.DogListActivity;
import com.example.lab5modify.warstwa1.HorseListActivity;

public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowDogs(View view) {
        Intent intent = new Intent(this, DogListActivity.class);
        startActivity(intent);
    }

    public void onShowCats(View view) {
        Intent intent = new Intent(this, CatListActivity.class);
        startActivity(intent);
    }

    public void onShowHorses(View view) {
        Intent intent = new Intent(this, HorseListActivity.class);
        startActivity(intent);
    }
}
