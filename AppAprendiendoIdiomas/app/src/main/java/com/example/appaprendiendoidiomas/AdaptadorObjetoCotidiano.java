package com.example.appaprendiendoidiomas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorObjetoCotidiano extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ObjetoCotidiano> objetoscotidianos;

    public AdaptadorObjetoCotidiano(Context context, int layout, ArrayList<ObjetoCotidiano> objetoscotidianos) {
        this.context = context;
        this.layout = layout;
        this.objetoscotidianos = objetoscotidianos;
    }

    @Override
    public int getCount() {
        return this.objetoscotidianos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.objetoscotidianos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Copiamos la vista
        View v = convertView;

        // Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.activity_objetos_cotidianos_listview, null);
        // Valor actual según la posición
        //String currentName = comunidades.get(position);
        ObjetoCotidiano objeto = objetoscotidianos.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView tv = v.findViewById(R.id.textView);
        tv.setText(objeto.getNombre());
        ImageView imv = v.findViewById(R.id.apr_objetos_image);
        imv.setImageResource(objeto.getImagen());

        // Devolvemos la vista inflada
        return v;
    }
}
