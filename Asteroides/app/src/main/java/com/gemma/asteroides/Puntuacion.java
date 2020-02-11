package com.gemma.asteroides;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Puntuacion extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> puntuaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);

        listView = findViewById(R.id.listview);

        puntuaciones = new ArrayList<>();
        puntuaciones.add("Gaspar 150pts");
        puntuaciones.add("Pablo 50pts");
        puntuaciones.add("Laura 70pts");
        puntuaciones.add("Pedro 15pts");
        puntuaciones.add("Julia 90pts");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, puntuaciones);
        listView.setAdapter(adapter);
    }
}
