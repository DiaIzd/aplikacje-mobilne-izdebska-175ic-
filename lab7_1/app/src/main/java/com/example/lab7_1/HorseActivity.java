package com.example.lab7_1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HorseActivity  extends AppCompatActivity {
    public static final String EXTRA_HORSEID="horseId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse);
        int horseId=(Integer)getIntent().getExtras().get(EXTRA_HORSEID);
        Horse horse=Horse.horses[horseId];

        TextView name=findViewById(R.id.horseName);
        name.setText(horse.getName());

        TextView description=findViewById(R.id.horseDescription);
        description.setText(horse.getDescription());

        ImageView photo=findViewById(R.id.horsePhoto);
        photo.setImageResource(horse.getImageResourceId());
        photo.setContentDescription(horse.getName());
        // Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

}




