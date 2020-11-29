package com.example.lab5modify.warstwa2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5modify.R;

public class CatDetail2Activity extends AppCompatActivity {
    public static final String EXTRA_CAT_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail2);
        CatDetailFragment frag=(CatDetailFragment) getSupportFragmentManager().findFragmentById(R.id.catDetail_frag);
        int catId=(int) getIntent().getExtras().get(EXTRA_CAT_ID);
        frag.setCat(catId);
    }

}
