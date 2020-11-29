package com.example.lab7_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "animals"; // Nazwa bazy danych
    private static final int DB_VERSION = 2; // Numer wersji bazy danych
    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DOG (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER,"
                    + "FAVORITE NUMERIC);");
            insertDog(db, "Chow Chow", "Ten chiński pies odznacza się jednak inteligencją – był zresztą kiedyś wykorzystywany podczas wojen i jako pies zaprzęgowy. Może mieć zatem zdolności do słuchania i współpracy.",
                    R.drawable.chow);
            insertDog(db, "Cocker spaniel amerykański", "Cocker spaniel amerykański to wyjątkowo przyjazny, zawsze wesoły zwierzak. Dzięki swojemu miłemu usposobieniu świetnie sprawdzi się jako towarzysz całej rodziny.",
                    R.drawable.cocker);
            insertDog(db, "West highland white terrier", "Mimo typowego dla teriera charakteru westie to czuły pies przywiązujący się do swoich bliskich.",
                    R.drawable.west);
        }

    }
    private static void insertDog(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues dogValues = new ContentValues();
        dogValues.put("NAME", name);
        dogValues.put("DESCRIPTION", description);
        dogValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DOG", null, dogValues);
    }
}