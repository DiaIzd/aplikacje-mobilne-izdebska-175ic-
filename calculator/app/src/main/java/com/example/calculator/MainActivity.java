package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView result;
 Button add,substract,multiply,divine;
 Spinner firstNumber, secondNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = (Spinner) findViewById(R.id.firstNumber);
        secondNumber = (Spinner) findViewById(R.id.secondNumber);
        result = (TextView) findViewById(R.id.result);
        add = (Button) findViewById(R.id.add);
        substract = (Button) findViewById(R.id.substracts);
        multiply = (Button) findViewById(R.id.multiply);
        divine = (Button) findViewById(R.id.divine);

    add.setOnClickListener(new View.OnClickListener()
    {
       @Override
       public void onClick(View v){
           double  numberOne= Double.parseDouble(firstNumber.getSelectedItem().toString());// String.valueOf(firstNumber.getSelectedItem());
           double  numberTwo =Double.parseDouble(secondNumber.getSelectedItem().toString());//String.valueOf(secondNumber.getSelectedItem());
           double  resultAll= numberOne+numberTwo;
           result.setText(String.valueOf(resultAll));
       }
    });
        substract.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                double  numberOne= Double.parseDouble(firstNumber.getSelectedItem().toString());
                double  numberTwo =Double.parseDouble(secondNumber.getSelectedItem().toString());
                double  resultAll= numberOne-numberTwo;
                result.setText(String.valueOf(resultAll));
            }
        });
        multiply.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                double numberOne= Double.parseDouble(firstNumber.getSelectedItem().toString());
                double numberTwo =Double.parseDouble(secondNumber.getSelectedItem().toString());
                double resultAll= numberOne*numberTwo;
                result.setText(String.valueOf(resultAll));
            }
        });
        divine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                double  numberOne= Double.parseDouble(firstNumber.getSelectedItem().toString());
                double  numberTwo =Double.parseDouble(secondNumber.getSelectedItem().toString());
                if(numberOne == 0.0 || numberTwo == 0.0){
                    result.setText("YOU NOT CAN DIVIDE WITH 0");
                }
                else{
                    double resultAll= numberOne/numberTwo;
                    result.setText(String.valueOf(resultAll));
                }

            }
        });
    }
//    public void onClickAdd(View view){
//        public void onClick(View v){
//            String numberOne= String.valueOf(firstNumber.getSelectedItem());//Integer.parseInt(firstNumber.getSelectedItem().toString());
//            String numberTwo =String.valueOf(secondNumber.getSelectedItem());//Integer.parseInt(firstNumber.getSelectedItem().toString());
//            String resultAll= numberOne+numberTwo;
//            result.setText(String.valueOf(resultAll));
//    }

}
