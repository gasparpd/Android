package com.example.appaprendiendoidiomas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjetosCotidianosAprender extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<ObjetoCotidiano> objetoscotidianos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos_cotidianos_listview);

        listView = findViewById(R.id.aprender_objetos_listview);
    }
}
