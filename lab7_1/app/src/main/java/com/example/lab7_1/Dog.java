package com.example.lab7_1;

import androidx.appcompat.app.AppCompatActivity;

public class Dog extends AppCompatActivity {

    private String name,description;
    private int imageResourceId;



    public static final Dog[] dogs={
            new Dog("Chow chow","Ten chiński pies odznacza się jednak inteligencją – był zresztą kiedyś wykorzystywany podczas wojen i jako pies zaprzęgowy. Może mieć zatem zdolności do słuchania i współpracy.", R.drawable.chow),
            new Dog("Cocker spaniel amerykański","Cocker spaniel amerykański to wyjątkowo przyjazny, zawsze wesoły zwierzak. Dzięki swojemu miłemu usposobieniu świetnie sprawdzi się jako towarzysz całej rodziny.",R.drawable.cocker),
            new Dog("West highland white terrier","Mimo typowego dla teriera charakteru westie to czuły pies przywiązujący się do swoich bliskich.",R.drawable.west)
    };
    private Dog (String name, String description, int imageResourceId) {
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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
