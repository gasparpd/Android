package com.example.appaprendiendoidiomas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityPractNumeros extends MainActivity {
    String [] array_num;
    int pos = 0, array_charged= -1;
    TextView tv_num, tv_title;
    EditText et_number;
    Button btn_aceptar, btn_generar, btn_0, btn_10, btn_20, btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pract_numeros);

        btn_0 = findViewById(R.id.btn_prac_num_0);
        btn_10 = findViewById(R.id.btn_prac_num_10);
        btn_20 = findViewById(R.id.btn_prac_num_20);
        btn_aceptar = findViewById(R.id.btn_practN_aceptar);
        btn_generar = findViewById(R.id.btn_pracN_generarNum);
        tv_num = findViewById(R.id.tv_practN_num);
        tv_title = findViewById(R.id.tv_practN_title);
        et_number = findViewById(R.id.txt_practicaN_number_name);
        btn_home = findViewById(R.id.btn_home_2);

        btn_aceptar.setEnabled(false);
        btn_generar.setEnabled(false);
        et_number.setEnabled(false);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void charge0 (View v){
        array_num = getResources().getStringArray(R.array.array_0_9);
        tv_num.setText("0 - 9");
        array_charged = 0;

        btn_generar.setEnabled(true);
    }

    public void charge10 (View v){
        array_num = getResources().getStringArray(R.array.array_10_19);
        tv_num.setText("10 - 19");
        array_charged = 10;

        btn_generar.setEnabled(true);
    }

    public void charge20 (View v){
        array_num = getResources().getStringArray(R.array.array_20_100);
        tv_num.setText("20 - 100");
        array_charged = 20;

        btn_generar.setEnabled(true);
    }

    public void generaNum (View view){
        if (array_charged == 0 ||array_charged == 10){
            if(pos == 10)
                pos = 0;
        }
        if (array_charged == 20){
            if(pos == 9)
                pos = 0;
        }

        String n = array_num[pos];
        tv_num.setText(n);
        pos++;

        if (!btn_aceptar.isEnabled()){
            btn_aceptar.setEnabled(true);
        }
        if(!et_number.isEnabled()){
            et_number.setEnabled(true);
        }
        et_number.setBackgroundColor(Color.TRANSPARENT);
    }

    public String comprobarNum (int position){
        String str_n_ingl = "";
        if(array_charged == 0){
            switch (position){
                case 0:
                    str_n_ingl = "ZERO";
                    break;
                case 1:
                    str_n_ingl = "ONE";
                    break;
                case 2:
                    str_n_ingl = "TWO";
                    break;
                case 3:
                    str_n_ingl = "THREE";
                    break;
                case 4:
                    str_n_ingl = "FOUR";
                    break;
                case 5:
                    str_n_ingl = "FIVE";
                    break;
                case 6:
                    str_n_ingl = "SIX";
                    break;
                case 7:
                    str_n_ingl = "SEVEN";
                    break;
                case 8:
                    str_n_ingl = "EIGHT";
                    break;
                case 9:
                    str_n_ingl = "NINE";
                    break;
            }
        } else if (array_charged == 10){
            switch (position){
                case 0:
                    str_n_ingl = "TEN";
                    break;
                case 1:
                    str_n_ingl = "ELEVEN";
                    break;
                case 2:
                    str_n_ingl = "TWELVE";
                    break;
                case 3:
                    str_n_ingl = "THIRTEEN";
                    break;
                case 4:
                    str_n_ingl = "FOURTEEN";
                    break;
                case 5:
                    str_n_ingl = "FIFTEEN";
                    break;
                case 6:
                    str_n_ingl = "SIXTEEN";
                    break;
                case 7:
                    str_n_ingl = "SEVENTEEN";
                    break;
                case 8:
                    str_n_ingl = "EIGHTEEN";
                    break;
                case 9:
                    str_n_ingl = "NINETEEN";
                    break;
            }
        }else if (array_charged == 20){
            switch (position){
                case 0:
                    str_n_ingl = "TWENTY";
                    break;
                case 1:
                    str_n_ingl = "THIRTY";
                    break;
                case 2:
                    str_n_ingl = "FORTY";
                    break;
                case 3:
                    str_n_ingl = "FIFTY";
                    break;
                case 4:
                    str_n_ingl = "SIXTY";
                    break;
                case 5:
                    str_n_ingl = "SEVENTY";
                    break;
                case 6:
                    str_n_ingl = "EIGHTY";
                    break;
                case 7:
                    str_n_ingl = "NINETY";
                    break;
                case 8:
                    str_n_ingl = "ONE HUNDRED";
                    break;
            }
        }
        return str_n_ingl;
    }

    public void aceptar (View view){
        String respuesta = et_number.getText().toString();

        String comp = comprobarNum(pos - 1);

        if(comp.equalsIgnoreCase(respuesta)){
            et_number.setBackgroundColor(Color.GREEN);
        }
        else{
            et_number.setBackgroundColor(Color.RED);
        }
    }
}
