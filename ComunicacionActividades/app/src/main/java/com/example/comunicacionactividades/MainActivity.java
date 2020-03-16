package com.example.comunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_verif;
    private EditText et_nombre;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.et_nombre);
        tv_resultado = findViewById(R.id.tv_resultado);
        btn_verif = findViewById(R.id.btn_verificar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String resultado = getIntent().getStringExtra("resultado");
        tv_resultado.setText(resultado);
    }

    public void verificar(View v) {
        String nombre = et_nombre.getText().toString();

        Intent i = new Intent(this, Condiciones.class);
        i.putExtra("nombre", nombre);
        startActivity(i);
    }
}
