package com.example.lab4_modify;

import androidx.appcompat.app.AppCompatActivity;

public class Dog extends AppCompatActivity {

    private String name,description;
    private String imageResourceName;



//    public static final Dog[] dogs={
//            new Dog("Chow chow","Ten chiński pies odznacza się jednak inteligencją – był zresztą kiedyś wykorzystywany podczas wojen i jako pies zaprzęgowy. Może mieć zatem zdolności do słuchania i współpracy.", R.drawable.chow),
//            new Dog("Cocker spaniel amerykański","Cocker spaniel amerykański to wyjątkowo przyjazny, zawsze wesoły zwierzak. Dzięki swojemu miłemu usposobieniu świetnie sprawdzi się jako towarzysz całej rodziny.",R.drawable.cocker),
//            new Dog("West highland white terrier","Mimo typowego dla teriera charakteru westie to czuły pies przywiązujący się do swoich bliskich.",R.drawable.west)
//    };
public Dog(String name, String description, String imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceName = imageResourceId;
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

    public String getImageResourceName() {
        return imageResourceName;
    }

    public void setImageResourceName(String imageResourceName) {
        this.imageResourceName = imageResourceName;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
