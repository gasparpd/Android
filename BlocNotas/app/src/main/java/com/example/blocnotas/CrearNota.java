package com.example.blocnotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CrearNota extends AppCompatActivity {

    private EditText editNombre;
    private EditText editNota;
    public ArrayList<Nota> lista;
    public Nota c;
    public MiBaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);

        editNombre= findViewById(R.id.etNombre);
        editNota= findViewById(R.id.etNota);
        bd=new MiBaseDeDatos(this);
        lista=bd.getNotas();
    }

    public void anadirNota (View view) {
        if ((editNombre.getText().length()>0) && (editNota.getText().length()>0)) {
            bd.insertar(editNombre.getText().toString(), editNota.getText().toString());
            editNombre.setText("");
            editNota.setText("");
        }
        else {
            Toast msg = Toast.makeText(this, "Debes introducir el nombre y contenido de una nota", Toast.LENGTH_SHORT);
            msg.show();
    }

    }
}
