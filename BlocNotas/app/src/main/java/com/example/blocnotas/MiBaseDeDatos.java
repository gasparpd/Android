package com.example.blocnotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class MiBaseDeDatos extends SQLiteOpenHelper {

    private static final String CREAR_TABLA_NOTAS = "CREATE TABLE notas(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, nota TEXT)";
    private static final String NOMBRE_BD = "notas.sqlite";
    private static final int VERSION_BD = 1;
    private SQLiteDatabase bd;

    public MiBaseDeDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CREAR_TABLA_NOTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {

    }

    public void insertar(String nombre,String nota){
        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("nota", nota);
        bd.insert("notas", null, cv);
    }

    public void borrar(int id) {
        String[] args = new String[]{String.valueOf(id)};
        bd.delete("notas", "_id=?", args);
    }

    public ArrayList<Nota> getNotas(){
        ArrayList<Nota> lista=new ArrayList<Nota>();
        Cursor c = bd.rawQuery("select _id, nombre,nota from notas", null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String nombre = c.getString(c.getColumnIndex("nombre"));
                String nota = c.getString(c.getColumnIndex("nota"));
                int id=c.getInt(c.getColumnIndex("_id"));
                Nota not =new Nota(id,nombre,nota);
                lista.add(not);
            } while (c.moveToNext());
        }

        c.close();
        return lista;
    }
}