package com.example.appaprendiendoidiomas;

public class ObjetoCotidiano {

    private String nombre;
    private int imagen;

    public ObjetoCotidiano(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public ObjetoCotidiano() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
