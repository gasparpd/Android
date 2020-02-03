package com.example.applistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<String> nombres;

    public MiAdaptador(Context context, int layout, ArrayList<String> nombres) {
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
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

        v = layoutInflater.inflate(R.layout.list_items, null);
        // Valor actual según la posición

        String currentName = nombres.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView tv = v.findViewById(R.id.textView);
        tv.setText(currentName);

        // Devolvemos la vista inflada
        return v;
    }


}
