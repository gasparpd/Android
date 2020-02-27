package com.gemma.asteroides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button jugar, configuracion, puntuaciones, acercaDe, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referenciamos botones por su identificador

        jugar = findViewById(R.id.btnJugar);
        configuracion = findViewById(R.id.btnConfiguracion);
        puntuaciones = findViewById(R.id.btnPuntuaciones);
        acercaDe = findViewById(R.id.btnAcercaDe);
        salir = findViewById(R.id.btnSalir);
    }

    // Creamos Opciones de menú en la barra de acciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; /* true -> el menú ya está visible */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            lanzarPreferencias();
            return true;
        }
        if (id == R.id.acercaDe) {
            lanzarAcercaDe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzarPreferencias(){
        Intent intent=new Intent(this, Preferencias.class);
        startActivity(intent);
    }

    // Métodos de opciones de menú de BarAction

    public void lanzarAcercaDe() {
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }

    // Opciones de los botones de la aplicación

    public void configurar(View view) {
        Intent intent = new Intent(this, Preferencias.class);
        startActivity(intent);
    }

    public void acercaDe(View view) {
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }

    public void salir(View view) {
        finish();
    }

    public void puntuacions(View view) {
        Intent i = new Intent(this, Puntuacion.class);
        startActivity(i);
    }

    public void lanzarJuego(View view) {
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }
}
