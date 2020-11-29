package com.example.lab5_animal.warstwa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lab5_animal.R;
import androidx.appcompat.app.AppCompatActivity;


import com.example.lab5_animal.warstwa1.CatListActivity;
import com.example.lab5_animal.warstwa1.DogListActivity;
import com.example.lab5_animal.warstwa1.HorseListActivity;

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
