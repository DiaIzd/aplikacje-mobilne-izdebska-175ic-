package com.example.lab4_modify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DOG_TABLE = "DOG_TABLE";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String IMAGE_RESOURCE_ID = "IMAGE_RESOURCE_ID";
    public static final String CAT_TABLE = "CAT_TABLE";
    public static final String HORSE_TABLE = "HORSE_TABLE";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "animal.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DOG_TABLE + " (" + NAME + " TEXT PRIMARY KEY, " + DESCRIPTION + " TEXT, " + IMAGE_RESOURCE_ID + " TEXT)";
        db.execSQL(createTableStatement);
        createTableStatement = "CREATE TABLE " + CAT_TABLE + " (" + NAME + " TEXT PRIMARY KEY, " + DESCRIPTION + " TEXT, " + IMAGE_RESOURCE_ID + " TEXT)";
        db.execSQL(createTableStatement);
        createTableStatement = "CREATE TABLE " + HORSE_TABLE + " (" + NAME + " TEXT PRIMARY KEY, " + DESCRIPTION + " TEXT, " + IMAGE_RESOURCE_ID + " TEXT)";
        db.execSQL(createTableStatement);
        addValuesToDogTable(db);
        addValuesToCatTable(db);
        addValuesToHorseTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void addValuesToDogTable(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();

        cv.put(NAME, "Chow chow");
        cv.put( DESCRIPTION, "Ten chiński pies odznacza się jednak inteligencją – był zresztą kiedyś wykorzystywany podczas wojen i jako pies zaprzęgowy. Może mieć zatem zdolności do słuchania i współpracy.");
        cv.put(IMAGE_RESOURCE_ID, "chow");
        db.insert(DOG_TABLE, null, cv);

        cv.put(NAME, "Cocker spaniel amerykański");
        cv.put( DESCRIPTION, "Cocker spaniel amerykański to wyjątkowo przyjazny, zawsze wesoły zwierzak. Dzięki swojemu miłemu usposobieniu świetnie sprawdzi się jako towarzysz całej rodziny.");
        cv.put(IMAGE_RESOURCE_ID, "cocker");
        db.insert(DOG_TABLE, null, cv);

        cv.put(NAME, "West highland white terrier");
        cv.put( DESCRIPTION, "Mimo typowego dla teriera charakteru westie to czuły pies przywiązujący się do swoich bliskich.");
        cv.put(IMAGE_RESOURCE_ID, "west");
        db.insert(DOG_TABLE, null, cv);
    }
    public void addValuesToCatTable(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(NAME, "Angora turecka");
        cv.put( DESCRIPTION, "Angora jest kotem stosunkowo gadatliwym i do komunikacji ze swoimi ludźmi używa szerokiego wachlarza miękkich i ekspresyjnych dźwięków.");
        cv.put(IMAGE_RESOURCE_ID, "turecka");
        db.insert(CAT_TABLE, null, cv);

        cv.put(NAME, "Kot szkocki zwisłouchy");
        cv.put( DESCRIPTION, "Skłonność do ucieczek\" +\n" +
                "                   \"Ponieważ ma ciekawską naturę, bez wahania odkrywa nowe rejony i powiększa życiową\n" +
                "                    przestrzeń, jeśli tylko trafi się okazja.");
        cv.put(IMAGE_RESOURCE_ID, "szkocki");
        db.insert(CAT_TABLE, null, cv);

        cv.put(NAME, "Doński sfinks");
        cv.put( DESCRIPTION, "Przy kocie tej rasy nikt nie będzie się nudził. Jak tylko posprzątacie jego zabawki, zaraz \n" + "zjawi się gotów do nowej zabawy! Oczywiście od czasu do czasu musi odpocząć, ale doński sfinks bardzo szybko regeneruje\n" +
                "siły.");
        cv.put(IMAGE_RESOURCE_ID, "sfinks");
        db.insert(CAT_TABLE, null, cv);
    }
    public void addValuesToHorseTable(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(NAME, "Konik polski");
        cv.put( DESCRIPTION, "To jedna z najstarszych polskich ras, której przodkiem jest dziki tarpan");
        cv.put(IMAGE_RESOURCE_ID, "konik");
        db.insert(HORSE_TABLE, null, cv);

        cv.put(NAME, "Albino");
        cv.put( DESCRIPTION, "Ich cechą charakterystyczną jest brak pigmentu w skórze, dzięki czemu ich sierść oraz grzywa są jasne – białe bądź lekko żółte.");
        cv.put(IMAGE_RESOURCE_ID, "albino");
        db.insert(HORSE_TABLE, null, cv);

        cv.put(NAME, "Koń andaluzyjski");
        cv.put( DESCRIPTION, "Konie te niegdyś były tak cenione, że ich wywóz bez zewolenia karany był śmiercią.");
        cv.put(IMAGE_RESOURCE_ID, "andaluzyjski");
        db.insert(HORSE_TABLE, null, cv);
    }
    public List<Dog> getDogsFromDogTable() {
        List<Dog> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + DOG_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        // db.beginTransaction();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();

        do {
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            String resourceId=cursor.getString(2);

            Dog dog = new Dog(name,description,resourceId);
            returnList.add(dog);
        } while (cursor.moveToNext());
        // db.endTransaction();
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Cat> getCatFromCatTable() {
        List<Cat> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CAT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        // db.beginTransaction();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();

        do {
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            String resourceName=cursor.getString(2);


            Cat cat = new Cat(name,description,resourceName);
            returnList.add(cat);
        } while (cursor.moveToNext());
        // db.endTransaction();
        cursor.close();
        db.close();
        return returnList;
    }
    public List<Horse> getHorsesFromHorseTable() {
        List<Horse> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + HORSE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        // db.beginTransaction();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();

        do {
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            String resourceName=cursor.getString(2);


            Horse horse = new Horse(name,description,resourceName);
            returnList.add(horse);
        } while (cursor.moveToNext());
        // db.endTransaction();
        cursor.close();
        db.close();
        return returnList;
    }
}
