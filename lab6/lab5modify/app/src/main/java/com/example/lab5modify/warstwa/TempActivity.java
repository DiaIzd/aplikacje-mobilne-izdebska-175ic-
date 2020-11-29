package com.example.lab5modify.warstwa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab5modify.R;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);
        if(savedInstanceState==null){
            StopwatchFragment stopwatch=new StopwatchFragment();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.add(R.id.stopwatch_container,stopwatch);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
}
