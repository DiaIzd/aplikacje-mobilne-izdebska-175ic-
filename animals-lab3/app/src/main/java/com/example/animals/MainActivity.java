package com.example.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence text = "Button with dog";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this,text,duration);
        toast.show();
    }

    public void onCheckboxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.dogs:
                if(checked){
                    Intent intent = new Intent(this,ActivityForFrame.class);
                startActivity(intent);}
        }
    }


    public void ClickMe(View view){
        Intent intent = new Intent(this,ActivityForFrame.class);
        startActivity(intent);
   }
}
