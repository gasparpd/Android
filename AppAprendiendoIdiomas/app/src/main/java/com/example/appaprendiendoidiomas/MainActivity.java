package com.example.appaprendiendoidiomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_colores, btn_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        btn_colores = findViewById(R.id.btn_principal_colores);
        btn_num = findViewById(R.id.btn_principal_numeros);
    }

    public void colores (View view){
        Intent i = new Intent(this, ActivityColores.class);
        startActivity(i);
    }

    public void numeros (View view){
        Intent i = new Intent(this, ActivityNumeros.class);
        startActivity(i);
    }
}
