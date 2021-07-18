package com.example.green;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
   public float MaleOrFemale;
   public double cups_water, perfect_weight, Daily_protein_intake;
   public float personHeight,personWeight,weight_per,weight_lbs,water,Number_cups_water,protein;
   public int personAge;
    EditText height;
    EditText weight;
    EditText age;
    TextView display;
    Button result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.person_height);
        weight = findViewById(R.id.person_weight);
        age = findViewById(R.id.person_age);
        display = findViewById(R.id.textViewResult);
        result = findViewById(R.id.button_result);


    }


    @SuppressLint("SetTextI18n")
    public void result_button(View view) {

        //Here we take the height of the body
         personHeight = Float.parseFloat(height.getText().toString());


         //Here we take the weight of the body
        personWeight = Float.parseFloat(weight.getText().toString());


        //Here we take the person's age
        personAge = Integer.parseInt(age.getText().toString());



        //Calculating the ideal body weight
        weight_per = personHeight - MaleOrFemale;
        perfect_weight = Double.parseDouble(new DecimalFormat("##.##").format(weight_per));

        //Convert body weight from kilograms to pounds
        weight_lbs = (float) (personWeight / 0.4536);
        water = (float) weight_lbs / 50;
        Number_cups_water = (float) (water / 0.25);


        //The result is how many cups of water we need per day
        cups_water = Double.parseDouble(new DecimalFormat("##.##").format(Number_cups_water));


        //The daily amount of protein the body needs
        protein = (float) (perfect_weight * 0.8);
        Daily_protein_intake = Double.parseDouble(new DecimalFormat("##.##").format(protein));


       display.setText("Perfect weight: " + perfect_weight + " Kg.\n" + "\nYour daily need for water: " + cups_water + " Cups of water.\n" + "\nYour daily need for protein: " + Daily_protein_intake + " Gram at least.");
       
    }


    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {

        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()){

            case R.id.radioButton_male:
                if(checked)
                    MaleOrFemale = 100; // return number 100
                    break;
            case R.id.radioButton_female:
                if(checked)
                    MaleOrFemale = 110; // return number 110
                    break;
        }
    }


    @Override
    public void onPause(){ //call before pause
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onStop(){ //leave activity
        super.onStop();
    }

    @Override
    public void onStart(){ //return back
        super.onStart();
    }

}
