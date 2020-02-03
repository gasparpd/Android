package com.example.missitios;

public interface Sitios {

    //Permite almacenar una lista de objetos Sitio
    //De momento usaremos una lista almacenada en memoria
    //Más adelante usaremos una base de datos

    Sitio elemento(int id); //Devuelve el elemento dado su id
    void annade(Sitio lugar); //Añade el elemento indicado
    int nuevo(); //Añade un elemento en blanco y devuelve su id
    void borrar(int id); //Elimina el elemento con el id indicado
    int tamanno(); //Devuelve el número de elementos
    void actualiza(int id, Sitio lugar); //Reemplaza un elemento
}