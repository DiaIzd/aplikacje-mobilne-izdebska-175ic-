package com.example.lab4_modify;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class DogActivity extends AppCompatActivity {
    public static final String EXTRA_DOGID="dogId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dog);
        int cakeId=(Integer)getIntent().getExtras().get(EXTRA_DOGID);
        DatabaseHelper databaseHelper=new DatabaseHelper(DogActivity.this);
        List<Dog> dogList;
        dogList=databaseHelper.getDogsFromDogTable();
        Dog dog= dogList.get(cakeId);

        TextView name=findViewById(R.id.dogName);
        name.setText(dog.getName());

        TextView description=findViewById(R.id.dogDescription);
        description.setText(dog.getDescription());

        ImageView photo=findViewById(R.id.dogPhoto);
        String iconName = dog.getImageResourceName();
        int resId=getResources().getIdentifier(iconName,"drawable",getPackageName());
        photo.setImageResource(resId);
        photo.setContentDescription(dog.getName());

    }
}
