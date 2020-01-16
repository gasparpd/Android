package com.example.blocnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class BorrarNota extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editNombre;
    private EditText editNota;
    private Spinner spinNotas;
    private ArrayAdapter spinnerAdapter;
    public ArrayList<Nota> lista;
    public Nota c;
    public MiBaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_nota);

        editNombre=(EditText)findViewById(R.id.etNombre);
        editNota=(EditText)findViewById(R.id.etNota);
        spinNotas=(Spinner)findViewById(R.id.spinnerNotas);
        bd=new MiBaseDeDatos(this);
        lista=bd.getNotas();
        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
        spinNotas.setAdapter(spinnerAdapter);
        spinNotas.setOnItemSelectedListener(this);
        editNombre.setEnabled(false);
        editNota.setEnabled(false);
    }

    public void verNota (View view){
        if(c!=null) {
            editNombre.setText(c.getNombre());
            editNota.setText(c.getNota());
        }
    }

    public void borrarNota (View view){
        if(c!=null) {
            bd.borrar(c.getId());
            lista = bd.getNotas();
            spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
            spinNotas.setAdapter(spinnerAdapter);

            editNombre.setText("");
            editNota.setText("");

            c=null;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerNotas) {
            if(lista.size()>0) {
                c = lista.get(position);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
