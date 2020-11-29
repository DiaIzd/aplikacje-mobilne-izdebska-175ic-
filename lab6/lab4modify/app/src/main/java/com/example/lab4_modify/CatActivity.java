package com.example.lab4_modify;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class CatActivity extends AppCompatActivity {
    public static final String EXTRA_CATID="catId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cat);
        int catId=(Integer)getIntent().getExtras().get(EXTRA_CATID);
        DatabaseHelper databaseHelper=new DatabaseHelper(CatActivity.this);
        List<Cat> catList;
        catList=databaseHelper.getCatFromCatTable();
        Cat cat= catList.get(catId);

        TextView name=findViewById(R.id.catName);
        name.setText(cat.getName());

        TextView description=findViewById(R.id.catDescription);
        description.setText(cat.getDescription());

        ImageView photo=findViewById(R.id.catPhoto);
        String iconName = cat.getImageResourceName();
        int resId=getResources().getIdentifier(iconName,"drawable",getPackageName());
        photo.setImageResource(resId);
        photo.setContentDescription(cat.getName());

    }
}