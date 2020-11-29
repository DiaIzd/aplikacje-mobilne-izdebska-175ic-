package com.example.lab7_1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Animals extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor favoritesCursor;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menumain,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_info:
                Intent intent=new Intent(this,Info.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(Animals.this,DogRace.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Animals.this,CatRace.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView=findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

        // Zapisujemy na liście list_favorites ulubione napoje użytkownika
        ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
        try {
            SQLiteOpenHelper coffeinaDatabaseHelper = new DatabaseHelper(this);
            db = coffeinaDatabaseHelper.getReadableDatabase();
            favoritesCursor = db.query("DOG",
                    new String[] { "_id", "NAME"},
                    "FAVORITE = 1",
                    null, null, null, null);


            CursorAdapter favoriteAdapter =
                    new SimpleCursorAdapter(Animals.this,
                            android.R.layout.simple_list_item_1,
                            favoritesCursor,
                            new String[]{"NAME"},
                            new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(Animals.this, DogActivity.class);
                intent.putExtra(DogActivity.EXTRA_DOGID, (int) id);
                startActivity(intent);
            }
        });
    }
    // W metodzie onDestroy() zamykamy kursor i bazę danych
    @Override
    public void onDestroy(){
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }
    public void onRestart() {
        super.onRestart();
        try {
            // Tworzymy nowy kursor
            DatabaseHelper coffeinaDatabaseHelper = new DatabaseHelper(this);
            db = coffeinaDatabaseHelper.getReadableDatabase();
            Cursor newCursor = db.query("DOG",
                    new String[] { "_id", "NAME"},
                    "FAVORITE = 1",
                    null, null, null, null);
            // Pobieramy adapter CursorAdapter używany przez widok ListView
            ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
            CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
            // Zmieniamy kursor używany przez adapter CursorAdapter na nowy
            adapter.changeCursor(newCursor);

            favoritesCursor = newCursor;
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
