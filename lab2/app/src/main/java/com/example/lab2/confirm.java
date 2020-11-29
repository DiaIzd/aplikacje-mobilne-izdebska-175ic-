package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
    }
    public void send(View view){
        Intent intent = new Intent(this, reciver.class);
        EditText var1 = (EditText) findViewById(R.id.editText2);
        String msg = var1.getText().toString();
        intent.putExtra(reciver.WIADOMOSC,msg);
        startActivity(intent);
    }
    public void home1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
