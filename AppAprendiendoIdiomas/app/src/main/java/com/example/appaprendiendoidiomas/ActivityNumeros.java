package com.example.appaprendiendoidiomas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityNumeros extends MainActivity {

    Spinner spinner;
    Button btn_0, btn_10, btn_20;
    FloatingActionButton btn_practica;
    int array_charged;
    TextView tv_numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        spinner = findViewById(R.id.spinner_apr_num);
        btn_0 = findViewById(R.id.btn_apr_num_0);
        btn_10 = findViewById(R.id.btn_apr_num_10);
        btn_20 = findViewById(R.id.btn_apr_num_20);
        btn_practica = findViewById(R.id.apr_num_btn_practica);
        tv_numbers = findViewById(R.id.tv_apr_num);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String string_num = comprobarNum(position);
                tv_numbers.setText(string_num);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setEnabled(false);
    }

    public void practicaNumeros(View view) {
        Intent i = new Intent(this, ActivityPractNumeros.class);
        startActivity(i);
    }

    public void charge0 (View v){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_0_9, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setEnabled(true);
        array_charged = 0;
    }

    public void charge10 (View v){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_10_19, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setEnabled(true);
        array_charged = 10;
    }

    public void charge20 (View v){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_20_100, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setEnabled(true);
        array_charged = 20;
    }

    public String comprobarNum (int position){
        String tv_num = "";
        if(array_charged == 0){
            switch (position){
                case 0:
                    tv_num = "ZERO";
                    break;
                case 1:
                    tv_num = "ONE";
                    break;
                case 2:
                    tv_num = "TWO";
                    break;
                case 3:
                    tv_num = "THREE";
                    break;
                case 4:
                    tv_num = "FOUR";
                    break;
                case 5:
                    tv_num = "FIVE";
                    break;
                case 6:
                    tv_num = "SIX";
                    break;
                case 7:
                    tv_num = "SEVEN";
                    break;
                case 8:
                    tv_num = "EIGHT";
                    break;
                case 9:
                    tv_num = "NINE";
                    break;
            }
        } else if (array_charged == 10){
            switch (position){
                case 0:
                    tv_num = "TEN";
                    break;
                case 1:
                    tv_num = "ELEVEN";
                    break;
                case 2:
                    tv_num = "TWELVE";
                    break;
                case 3:
                    tv_num = "THIRTEEN";
                    break;
                case 4:
                    tv_num = "FOURTEEN";
                    break;
                case 5:
                    tv_num = "FIFTEEN";
                    break;
                case 6:
                    tv_num = "SIXTEEN";
                    break;
                case 7:
                    tv_num = "SEVENTEEN";
                    break;
                case 8:
                    tv_num = "EIGHTEEN";
                    break;
                case 9:
                    tv_num = "NINETEEN";
                    break;
            }
        }else if (array_charged == 20){
            switch (position){
                case 0:
                    tv_num = "TWENTY";
                    break;
                case 1:
                    tv_num = "THIRTY";
                    break;
                case 2:
                    tv_num = "FORTY";
                    break;
                case 3:
                    tv_num = "FIFTY";
                    break;
                case 4:
                    tv_num = "SIXTY";
                    break;
                case 5:
                    tv_num = "SEVENTY";
                    break;
                case 6:
                    tv_num = "EIGHTY";
                    break;
                case 7:
                    tv_num = "NINETY";
                    break;
                case 8:
                    tv_num = "ONE HUNDRED";
                    break;
            }
        }
        return tv_num;
    }

}
