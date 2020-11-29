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

public class DogActivity extends AppCompatActivity {
    public static final String EXTRA_DOGID="dogId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        int dogId=(Integer)getIntent().getExtras().get(EXTRA_DOGID);
        try
        {
            SQLiteOpenHelper databaseHelper=new DatabaseHelper(this);
            SQLiteDatabase db=databaseHelper.getWritableDatabase();
            Cursor cursor=db.query("DOG", new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID","FAVORITE"},"_id=?",new String[]{Integer.toString(dogId)},null,null,null);
            if(cursor.moveToFirst())
            {
                String nameText=cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);
                // Wyświetlamy nazwę napoju
                TextView name=findViewById(R.id.dogName);
                name.setText(nameText);
                // Wyświetlamy opis napoju
                TextView description=findViewById(R.id.dogDescription);
                description.setText(descriptionText);
                // Wyświetlamy zdjęcie napoju
                ImageView photo = findViewById(R.id.dogPhoto);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
                // Zaznaczamy pole wyboru ulubionego napoju
                CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        }   catch (SQLiteException e)
        {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna",
                    Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    // Aktualizujemy bazę danych po kliknięciu pola wyboru
    public void onFavoriteClicked(View view){
        int dogNo = (Integer)getIntent().getExtras().get(EXTRA_DOGID);
        new UpdateDogTask().execute(dogNo);
    }

    private class UpdateDogTask extends AsyncTask<Integer, Void, Boolean> {
        ContentValues dogValues;
        protected void onPreExecute() {
            CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            dogValues = new ContentValues();
            dogValues.put("FAVORITE", favorite.isChecked());
        }
        protected Boolean doInBackground(Integer... dogs) {
            int dogNo = dogs[0];
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(DogActivity.this);
            try {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.update("DOG",  dogValues,
                        "_id = ?", new String[] {Integer.toString(dogNo)});
                db.close();
                return true;
            } catch(SQLiteException e) {
                return false;
            }
        }
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(DogActivity.this,
                        "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}