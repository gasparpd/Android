package com.example.appaprendiendoidiomas;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticaObjetos extends MainActivity {
    private String name;
    private int posicion = 0;
    private ArrayList<ObjetoCotidiano> objetos;
    private ImageView imagenObjeto, img2;
    private Button btn_validar, btn_cambiarObjeto;
    private EditText txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_objetos);

        img2 = findViewById(R.id.pract_objetos_imgv);
        imagenObjeto = findViewById(R.id.apr_objetos_image);
        btn_validar = findViewById(R.id.pract_objetos_btn_validar);
        btn_cambiarObjeto = findViewById(R.id.pract_objetos_btn_cambiar);
        txt_name = findViewById(R.id.pract_objetos_object_name);

        objetos = new ArrayList<>();
        objetos.add(new ObjetoCotidiano("BALÓN", R.drawable.balon, "BALL"));
        objetos.add(new ObjetoCotidiano("CEPILLO DEL PELO", R.drawable.cepillo_pelo, "HAIR BRUSH"));
        objetos.add(new ObjetoCotidiano("BOLÍGRAFO", R.drawable.boli, "PEN"));
        objetos.add(new ObjetoCotidiano("CAMA", R.drawable.cama, "BED"));
        objetos.add(new ObjetoCotidiano("CEPILLO DE DIENTES", R.drawable.cepillo_dientes, "TOOTHBRUSH"));
        objetos.add(new ObjetoCotidiano("CONO", R.drawable.cono, "WORK CONE"));
        objetos.add(new ObjetoCotidiano("LÁPIZ", R.drawable.lapiz, "PENCIL"));
        objetos.add(new ObjetoCotidiano("LLAVES", R.drawable.llaves, "KEYS"));
        objetos.add(new ObjetoCotidiano("RELOJ", R.drawable.reloj, "WATCH"));
        objetos.add(new ObjetoCotidiano("TIJERAS", R.drawable.tijeras, "SCISSORS"));

        btn_validar.setEnabled(false);
        txt_name.setEnabled(false);
    }

    public void cambiarObjeto(View view) {
        if (posicion >= objetos.size()) {
            posicion = 0;
        }

        img2.setImageResource(objetos.get(posicion).getImagen());
        name = objetos.get(posicion).getName();
        btn_validar.setEnabled(true);
        txt_name.setEnabled(true);
        posicion++;
    }

    public void validarObjeto(View view) {
        String inputName = txt_name.getText().toString();

        if (inputName.equalsIgnoreCase(name)) {
            txt_name.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "¡HAS ACERTADO!", Toast.LENGTH_SHORT).show();
        } else {
            txt_name.setBackgroundColor(Color.RED);
            Toast.makeText(this, "HAS FALLADO", Toast.LENGTH_SHORT).show();
        }
    }
}
