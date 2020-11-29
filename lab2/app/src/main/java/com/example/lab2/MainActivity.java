package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sender(View view){
        EditText var1 = (EditText) findViewById(R.id.editText);
        String msg = var1.getText().toString();
        Intent intent = new Intent(this, reciver.class);
        intent.putExtra(reciver.WIADOMOSC,msg);
        startActivity(intent);
    }
    public void panda(View view){
        Intent intent = new Intent(this, confirm.class);
        startActivity(intent);
    }
}
