package com.example.comunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Condiciones extends AppCompatActivity {
    private String nombre, resultado;
    private Button btn_aceptar, btn_rechazar;
    private TextView tv_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);

        tv_texto = findViewById(R.id.tv_condiciones);
        btn_aceptar = findViewById(R.id.btn_condi_aceptar);
        btn_rechazar = findViewById(R.id.btn_condi_deny);
        nombre = getIntent().getStringExtra("nombre");
        String texto = "Hola, " + nombre + ", ¿Aceptas las condiciones?";

        tv_texto.setText(texto);
    }

    public void aceptar(View v) {
        Intent i = new Intent(this, MainActivity.class);
        resultado = "Aceptado";
        i.putExtra("resultado", resultado);
        startActivity(i);
    }

    public void rechazar(View v) {
        Intent i = new Intent(this, MainActivity.class);
        resultado = "Rechazado";
        i.putExtra("resultado", resultado);
        startActivity(i);
    }
}
