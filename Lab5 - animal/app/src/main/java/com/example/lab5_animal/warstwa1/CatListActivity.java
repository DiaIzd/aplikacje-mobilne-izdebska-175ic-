package com.example.lab5_animal.warstwa1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5_animal.R;
import com.example.lab5_animal.model.Cat;
import com.example.lab5_animal.warstwa2.CatDetail2Activity;

public class CatListActivity extends AppCompatActivity implements CatListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);
    }
    @Override
    public void itemClicked(long id){
        Intent intent=new Intent(this, CatDetail2Activity.class);
        intent.putExtra(CatDetail2Activity.EXTRA_CAT_ID,(int)id);
        startActivity(intent);
    }
}
