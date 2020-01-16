package com.example.blocnotas;

public class Nota {

    //Campos correspondientes a la base de datos
    int id;
    String nombre;
    String nota;

    //Constructor
    public Nota(int _id,String _nombre,String _nota){
        id=_id;
        nombre=_nombre;
        nota=_nota;
    }

    //Represetación del objeto como cadena de texto
    @Override
    public String toString() {
        return nombre;
    }

    //Métodos de acceso a cada atributo de la clase
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNota(){
        return nota;
    }
}
