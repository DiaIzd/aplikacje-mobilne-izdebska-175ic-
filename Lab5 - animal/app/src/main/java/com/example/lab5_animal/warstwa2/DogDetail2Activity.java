package com.example.lab5_animal.warstwa2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5_animal.R;

public class DogDetail2Activity extends AppCompatActivity {
    public static final String EXTRA_DOG_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail2);
        DogDetailFragment frag=(DogDetailFragment) getSupportFragmentManager().findFragmentById(R.id.dogDetail_frag);
        int dogId=(int) getIntent().getExtras().get(EXTRA_DOG_ID);
        frag.setDog(dogId);
    }

}
