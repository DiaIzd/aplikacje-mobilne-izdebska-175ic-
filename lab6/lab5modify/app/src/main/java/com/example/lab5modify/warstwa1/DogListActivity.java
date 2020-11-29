package com.example.lab5modify.warstwa1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5modify.R;
import com.example.lab5modify.warstwa2.DogDetail2Activity;

public class DogListActivity extends AppCompatActivity implements DogListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_list);
    }
    @Override
    public void itemClicked(long id){
        Intent intent=new Intent(this, DogDetail2Activity.class);
        intent.putExtra(DogDetail2Activity.EXTRA_DOG_ID,(int)id);
        startActivity(intent);
    }
}
