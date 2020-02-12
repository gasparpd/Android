package com.example.appaprendiendoidiomas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityPracticaColores extends MainActivity {
    int pos = 0; String name; Colores [] colores;
    TextView tv_colores;
    EditText et_color;
    Button btn_aceptar, btn_generar,  btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_colores);

        colores = new Colores[5];
        colores[0] = new Colores("ROJO", "RED", Color.RED);
        colores[1] = new Colores("AMARILLO", "YELLOW", Color.YELLOW);
        colores[2] = new Colores("AZUL", "BLUE", Color.BLUE);
        colores[3] = new Colores("VERDE", "GREEN", Color.GREEN);
        colores[4] = new Colores("NEGRO", "BLACK", Color.BLACK);

        tv_colores = findViewById(R.id.tv_colores_practica);
        et_color = findViewById(R.id.txt_practicaC_color_name);
        btn_aceptar = findViewById(R.id.btn_practC_aceptar);
        btn_generar = findViewById(R.id.btn_practC_cambiar_color);
        btn_home = findViewById(R.id.btn_home);

        btn_aceptar.setEnabled(false);
        et_color.setEnabled(false);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void generarColor(View view) {
        if(pos == 5){
            pos = 0;
        }

        tv_colores.setText(colores[pos].getNombre());
        name = colores[pos].getName();

        pos++;

        if (!btn_aceptar.isEnabled()){
            btn_aceptar.setEnabled(true);
        }
        if(!et_color.isEnabled()){
            et_color.setEnabled(true);
        }
        et_color.setBackgroundColor(Color.TRANSPARENT);
    }

    public void aceptar(View view){
        String nombre = et_color.getText().toString();
        if(nombre.equalsIgnoreCase(name)){
            et_color.setBackgroundColor(Color.GREEN);
        } else {
            et_color.setBackgroundColor(Color.RED);
        }
    }
}
