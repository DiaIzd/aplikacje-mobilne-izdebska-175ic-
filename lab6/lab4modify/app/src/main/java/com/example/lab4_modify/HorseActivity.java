package com.example.lab4_modify;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class HorseActivity extends AppCompatActivity {
    public static final String EXTRA_HORSEID="horseId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_horse);
        int cakeId=(Integer)getIntent().getExtras().get(EXTRA_HORSEID);
        DatabaseHelper databaseHelper=new DatabaseHelper(HorseActivity.this);
        List<Horse> horseList;
        horseList=databaseHelper.getHorsesFromHorseTable();
        Horse horse= horseList.get(cakeId);

        TextView name=findViewById(R.id.horseName);
        name.setText(horse.getName());

        TextView description=findViewById(R.id.horseDescription);
        description.setText(horse.getDescription());

        ImageView photo=findViewById(R.id.horsePhoto);
        String iconName = horse.getImageResourceName();
        int resId=getResources().getIdentifier(iconName,"drawable",getPackageName());
        photo.setImageResource(resId);
        photo.setContentDescription(horse.getName());

    }
}