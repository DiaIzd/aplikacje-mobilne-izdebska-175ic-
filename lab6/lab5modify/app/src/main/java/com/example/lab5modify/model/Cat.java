package com.example.lab5modify.model;

import androidx.appcompat.app.AppCompatActivity;

public class Cat extends AppCompatActivity {

    private String name,description;
    private String imageResourceId;

    //    public static final Cat[] cats={
//            new Cat("Angora turecka","Angora jest kotem stosunkowo gadatliwym i do komunikacji ze swoimi ludźmi używa szerokiego wachlarza miękkich i ekspresyjnych dźwięków.", R.drawable.turecka),
//            new Cat("Kot szkocki zwisłouchy","Skłonność do ucieczek" +
//                    "Ponieważ ma ciekawską naturę, bez wahania odkrywa nowe rejony i powiększa życiową przestrzeń, jeśli tylko trafi się okazja. ",R.drawable.szkocki),
//            new Cat("Doński sfinks","Przy kocie tej rasy nikt nie będzie się nudził. Jak tylko posprzątacie jego zabawki, zaraz zjawi się gotów do nowej zabawy! Oczywiście od czasu do czasu musi odpocząć, ale doński sfinks bardzo szybko regeneruje siły.",R.drawable.sfinks)
//    };
    public Cat(String name, String description, String imageResourceId) {
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
