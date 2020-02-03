package com.example.applistview;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    //private ArrayList<String> comunidad;
    private ArrayList <ComunidadesAutonomas> comunidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        comunidad = new ArrayList<ComunidadesAutonomas>();
        comunidad.add(0, new ComunidadesAutonomas("Principado de Asturias", R.drawable.asturias_bandera));
        comunidad.add( 1, new ComunidadesAutonomas("Galicia", R.drawable.galicia_bandera));
        comunidad.add(2,new ComunidadesAutonomas("Cantabria", R.drawable.cantabria));
        comunidad.add(3,new ComunidadesAutonomas("País Vasco", R.drawable.pais_vasco));
        /*comunidad.add("Castilla-León");
        comunidad.add("Cataluña");
        comunidad.add("La Rioja");
        comunidad.add("Castilla-La Mancha");
        comunidad.add("Extremadura");
        */
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comunidad);
        listView.setAdapter(adapter);
        */

        //Implemetanos nuestro adaptador personalizado
        MiAdaptador miadaptador = new MiAdaptador(this, R.layout.list_items, comunidad);
        listView.setAdapter(miadaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has pulsado: " + comunidad.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
