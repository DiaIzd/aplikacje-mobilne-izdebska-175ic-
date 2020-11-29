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

public class CatActivity extends AppCompatActivity {
    public static final String EXTRA_CATID="catId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cat);
        int catId=(Integer)getIntent().getExtras().get(EXTRA_CATID);
        Cat cat=Cat.cats[catId];

        TextView name=findViewById(R.id.catName);
        name.setText(cat.getName());

        TextView description=findViewById(R.id.catDescription);
        description.setText(cat.getDescription());

        ImageView photo=findViewById(R.id.catPhoto);
        photo.setImageResource(cat.getImageResourceId());
        photo.setContentDescription(cat.getName());
        // Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
}