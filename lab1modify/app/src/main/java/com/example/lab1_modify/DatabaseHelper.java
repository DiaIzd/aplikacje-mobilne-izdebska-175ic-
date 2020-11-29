package com.example.lab1_modify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String FIRST_NUMBER_TABLE = "FIRST_NUMBER_TABLE";
    public static final String NUMBER_VALUE = "NUMBER_VALUE";
    public static final String ID = "ID";
    public static final String SECOND_NUMBER_TABLE = "SECOND_NUMBER_TABLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "numbers.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + FIRST_NUMBER_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NUMBER_VALUE + " INT )";
        db.execSQL(createTableStatement);
        createTableStatement= "CREATE TABLE " + SECOND_NUMBER_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NUMBER_VALUE + " INT )";
        db.execSQL(createTableStatement);
        addValuesToFirstTable(db);
        addValuesToSecondTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  void addValuesToFirstTable(SQLiteDatabase db){
        //db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(NUMBER_VALUE,1);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,2);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,5);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,10);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,20);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,30);
        db.insert(FIRST_NUMBER_TABLE,null,cv);
    }
    public void addValuesToSecondTable(SQLiteDatabase db){
        //db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(NUMBER_VALUE,0);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,1);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,2);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,5);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,10);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,20);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
        cv.put(NUMBER_VALUE,30);
        db.insert(SECOND_NUMBER_TABLE,null,cv);
    }
    public List<Number> getNumbersFromFirstTable() {
        List<Number> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + FIRST_NUMBER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        // db.beginTransaction();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();

        do {
            int numberId = cursor.getInt(0);
            int numberValue = cursor.getInt(1);

            Numbers numbers = new Numbers(numberId, numberValue);
            returnList.add(numbers);
        } while (cursor.moveToNext());
        // db.endTransaction();
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Number> getNumbersFromSecondTable()
    {
        List<Number> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + SECOND_NUMBER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();


        do {
            int numberId = cursor.getInt(0);
            int numberValue = cursor.getInt(1);

            Numbers numbers1 = new Numbers(numberId, numberValue);
            returnList.add(numbers1);
        } while (cursor.moveToNext());

        //  db.endTransaction();
        cursor.close();
        db.close();
        return returnList;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

    }
}