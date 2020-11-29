package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class reciver extends AppCompatActivity {

    public static final String WIADOMOSC = "mess";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);
        Intent intent = getIntent();
        String MessText = intent.getStringExtra(WIADOMOSC);
        TextView message = (TextView) findViewById(R.id.textView);
        message.setText(MessText);
    }
    public void panda(View view){
        Intent intent = new Intent(this, confirm.class);
        startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
