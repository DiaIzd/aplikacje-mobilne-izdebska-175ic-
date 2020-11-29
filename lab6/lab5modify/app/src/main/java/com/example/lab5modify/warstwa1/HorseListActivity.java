package com.example.lab5modify.warstwa1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5modify.R;
import com.example.lab5modify.warstwa2.HorseDetail2Activity;

public class HorseListActivity extends AppCompatActivity implements HorseListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_list);
    }
    @Override
    public void itemClicked(long id){
        Intent intent=new Intent(this, HorseDetail2Activity.class);
        intent.putExtra(HorseDetail2Activity.EXTRA_HORSE_ID,(int)id);
        startActivity(intent);
    }
}
