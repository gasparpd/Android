package com.example.wikianimales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Animal> animales;

    public MiAdaptador(Context context, int layout, ArrayList<Animal> anim) {
        this.context = context;
        this.layout = layout;
        this.animales = anim;
    }

    @Override
    public int getCount() {
        return this.animales.size();
    }

    @Override
    public Object getItem(int position) {
        return this.animales.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        // Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.entrada, null);
        // Valor actual según la posición
        Animal animal = animales.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView tv = v.findViewById(R.id.tv_titulo);
        tv.setText(animal.getTitulo());

        ImageView imv = v.findViewById(R.id.imageView);
        imv.setImageResource(animal.getImagen());

        TextView comentario = v.findViewById(R.id.tv_comentario);
        comentario.setText(animal.getComentario());

        // Devolvemos la vista inflada
        return v;
    }


}
