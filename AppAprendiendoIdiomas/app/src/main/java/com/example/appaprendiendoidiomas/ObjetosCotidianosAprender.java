package com.example.appaprendiendoidiomas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ObjetosCotidianosAprender extends MainActivity {

    private ListView listView;
    private ArrayList<ObjetoCotidiano> objetoscotidianos;
    private FloatingActionButton btn_practicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos_cotidianos_listview);

        listView = findViewById(R.id.aprender_objetos_listview);
        btn_practicar = findViewById(R.id.apr_objetos_floating_button);

        objetoscotidianos = new ArrayList<ObjetoCotidiano>();
        objetoscotidianos.add(new ObjetoCotidiano("BALÓN", R.drawable.balon, "BALL"));
        objetoscotidianos.add(new ObjetoCotidiano("CEPILLO DEL PELO", R.drawable.cepillo_pelo, "HAIR BRUSH"));
        objetoscotidianos.add(new ObjetoCotidiano("BOLÍGRAFO", R.drawable.boli, "PEN"));
        objetoscotidianos.add(new ObjetoCotidiano("CAMA", R.drawable.cama, "BED"));
        objetoscotidianos.add(new ObjetoCotidiano("CEPILLO DE DIENTES", R.drawable.cepillo_dientes, "TOOTHBRUSH"));
        objetoscotidianos.add(new ObjetoCotidiano("CONO", R.drawable.cono, "WORK CONE"));
        objetoscotidianos.add(new ObjetoCotidiano("LÁPIZ", R.drawable.lapiz, "PENCIL"));
        objetoscotidianos.add(new ObjetoCotidiano("LLAVES", R.drawable.llaves, "KEYS"));
        objetoscotidianos.add(new ObjetoCotidiano("RELOJ", R.drawable.reloj, "WATCH"));
        objetoscotidianos.add(new ObjetoCotidiano("TIJERAS", R.drawable.tijeras, "SCISSORS"));

        //Implemetanos nuestro adaptador personalizado
        AdaptadorObjetoCotidiano miadaptador = new AdaptadorObjetoCotidiano(this, R.layout.objetos_layout_items, objetoscotidianos);
        listView.setAdapter(miadaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ObjetosCotidianosAprender.this, objetoscotidianos.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void practicarObjetos(View view) {
        Intent i = new Intent(this, PracticaObjetos.class);
        startActivity(i);
    }
}
