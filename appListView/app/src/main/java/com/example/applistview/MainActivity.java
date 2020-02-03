package com.example.applistview;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        nombres = new ArrayList<String>();
        nombres.add("Principado de Asturias");
        nombres.add("Galicia");
        nombres.add("cantabria");
        nombres.add("País Vasco");
        nombres.add("Castilla-León");
        nombres.add("Cataluña");
        nombres.add("La Rioja");
        nombres.add("Castilla-La Mancha");
        nombres.add("Extremadura");

        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(adapter);
        */

        //Implemetanos nuestro adaptador personalizado
        MiAdaptador miadaptador = new MiAdaptador(this, R.layout.list_items, nombres);
        listView.setAdapter(miadaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has pulsado: " + nombres.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
