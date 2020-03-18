package com.example.appaprendiendoidiomas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class ActivityColores extends MainActivity {

    RadioButton rb_rojo, rb_azul, rb_amarillo, rb_verde, rb_negro;
    ImageView img_color;
    TextView tv_colores;
    Button btn_practica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        rb_rojo = findViewById(R.id.rb_rojo);
        rb_azul = findViewById(R.id.rb_azul);
        rb_amarillo = findViewById(R.id.rb_amarillo);
        rb_verde = findViewById(R.id.rb_verde);
        rb_negro = findViewById(R.id.rb_negro);

        img_color = findViewById(R.id.img_color);

        tv_colores = findViewById(R.id.tv_colores_aprend);

        btn_practica = findViewById(R.id.btn_practica);
    }

    public void rbRojo (View view){
        img_color.setBackgroundColor(RED);
        tv_colores.setText("RED");
    }
    public void rbAzul (View view){
        img_color.setBackgroundColor(BLUE);
        tv_colores.setText("BLUE");
    }
    public void rbAmar (View view){
        img_color.setBackgroundColor(YELLOW);
        tv_colores.setText("YELLOW");
    }
    public void rbVerde (View view){
        img_color.setBackgroundColor(GREEN);
        tv_colores.setText("GREEN");
    }
    public void rbNegro (View view){
        img_color.setBackgroundColor(BLACK);
        tv_colores.setText("BLACK");
    }

    public void practicarColores(View view) {
        Intent i = new Intent(this, ActivityPracticaColores.class);
        startActivity(i);
    }
}
