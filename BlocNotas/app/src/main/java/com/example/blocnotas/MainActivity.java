package com.example.blocnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearNota (View view){
        Intent intent=new Intent(this,CrearNota.class);
        startActivity(intent);
    }

    public void buscarNota (View view){
        Intent intent=new Intent(this,BuscarNota.class);
        startActivity(intent);
    }

    public void borrarNota (View view){
        Intent intent=new Intent(this,BorrarNota.class);
        startActivity(intent);
    }
}
