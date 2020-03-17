package com.example.appaprendiendoidiomas;

public class ObjetoCotidiano {

    private String nombre;
    private int imagen;
    private String name;

    public ObjetoCotidiano(String nombre, int imagen, String name) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
