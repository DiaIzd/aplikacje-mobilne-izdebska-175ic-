package com.example.lab1_modify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Button add,substract,multiply,divine;
    Spinner firstNumber, secondNumber;
    DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this);


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
        //databaseHelper.addValuesToFirstTable();
        //databaseHelper.addValuesToSecondTable();
        addNumbersToSpinners();
    }

    public void add(View view) {

        Double  numberOne=Double.valueOf(String.valueOf(firstNumber.getSelectedItem()));
        Double numberTwo=Double.valueOf(String.valueOf(secondNumber.getSelectedItem()));
        double  resultAll= numberOne+numberTwo;
        result.setText(String.valueOf(resultAll));
    }
    public void substract(View view) {
        Double numberOne=Double.valueOf(String.valueOf(firstNumber.getSelectedItem()));
        Double numberTwo=Double.valueOf(String.valueOf(secondNumber.getSelectedItem()));
        double  resultAll= numberOne-numberTwo;
        result.setText(String.valueOf(resultAll));
    }
    public void multiply(View view) {

        Double numberOne=Double.valueOf(String.valueOf(firstNumber.getSelectedItem()));
        Double numberTwo=Double.valueOf(String.valueOf(secondNumber.getSelectedItem()));
        double resultAll= numberOne*numberTwo;
        result.setText(String.valueOf(resultAll));
    }

    public void divine(View view) {
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




    public void addNumbersToSpinners()
    {
        Spinner first=findViewById(R.id.firstNumber);
        Spinner second=findViewById(R.id.secondNumber);

        List<Number> insertList=new ArrayList<>();


        insertList=databaseHelper.getNumbersFromFirstTable();
        ArrayAdapter arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,insertList);
        first.setAdapter(arrayAdapter);

        insertList=databaseHelper.getNumbersFromSecondTable();
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,insertList);
        second.setAdapter(arrayAdapter);

    }

}
