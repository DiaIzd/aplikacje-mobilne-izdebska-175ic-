package com.example.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityForFrame extends Activity {
    private boolean catss, puppy;
    private String textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_frame);
        CharSequence text = "Westie on Holidays";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this,text,duration);
        toast.show();
    }
    public void Cats(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.dogs:
                if (checked) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
        }
    }

    public void HauClickMe(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
