package com.example.blocnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.menu_item_crear:
                crearNota(this.getCurrentFocus());
                break;
            case R.id.menu_item_buscar:
                buscarNota(this.getCurrentFocus());
                break;
            case R.id.menu_item_eliminar:
                borrarNota(this.getCurrentFocus());
                break;
        }
        return true;
    }
}
