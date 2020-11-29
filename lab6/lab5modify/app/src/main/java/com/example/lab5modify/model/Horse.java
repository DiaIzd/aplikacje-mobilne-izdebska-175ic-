package com.example.lab5modify.model;

import androidx.appcompat.app.AppCompatActivity;

public class Horse extends AppCompatActivity {

    private String name,description;
    private String imageResourceId;

    //    public static final Horse[] horses ={
//            new Horse("Konik polski","To jedna z najstarszych polskich ras, której przodkiem jest dziki tarpan", R.drawable.konik),
//            new Horse("Albino","Ich cechą charakterystyczną jest brak pigmentu w skórze, dzięki czemu ich sierść oraz grzywa są jasne – białe bądź lekko żółte.",R.drawable.albino),
//            new Horse("Koń andaluzyjski","Konie te niegdyś były tak cenione, że ich wywóz bez zewolenia karany był śmiercią.",R.drawable.andaluzyjski)
//    };
    public Horse(String name, String description, String imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(String imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
