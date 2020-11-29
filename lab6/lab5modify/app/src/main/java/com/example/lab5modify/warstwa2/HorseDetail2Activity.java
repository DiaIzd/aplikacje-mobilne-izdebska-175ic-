package com.example.lab5modify.warstwa2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5modify.R;

public class HorseDetail2Activity extends AppCompatActivity {
    public static final String EXTRA_HORSE_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_detail2);
        HorseDetailFragment frag=(HorseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.horseDetail_frag);
        int horseId=(int) getIntent().getExtras().get(EXTRA_HORSE_ID);
        frag.setHorse(horseId);
    }

}
