package com.example.wikianimales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Animal> animales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        listView = findViewById(R.id.listview);

        animales = new ArrayList<>();
        animales.add(new Animal("BUHO", R.drawable.img_buho, getString(R.string.desc_buho)));
        animales.add(new Animal("COLIBRÍ", R.drawable.img_colibri, getString(R.string.desc_colibri)));
        animales.add(new Animal("CUERVO", R.drawable.img_cuervo, getString(R.string.desc_cuervo)));
        animales.add(new Animal("FLAMENCO", R.drawable.img_flamenco, getString(R.string.desc_flamenco)));
        animales.add(new Animal("KIWI", R.drawable.img_kiwi, getString(R.string.desc_kiwi)));
        animales.add(new Animal("LORO", R.drawable.img_loro, getString(R.string.desc_loro)));
        animales.add(new Animal("PAVO", R.drawable.img_pavo, getString(R.string.desc_pavo)));
        animales.add(new Animal("PINGÜINO", R.drawable.img_pinguino, getString(R.string.desc_pinguino)));

        //Implemetanos nuestro adaptador personalizado
        MiAdaptador miadaptador = new MiAdaptador(this, R.layout.entrada, animales);
        listView.setAdapter(miadaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, animales.get(position).getComentario(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
