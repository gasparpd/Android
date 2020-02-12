package com.example.appaprendiendoidiomas;

public class Colores {

    String nombre;
    String name;
    int code;

    public Colores(String nombre, String name, int code) {
        this.nombre = nombre;
        this.name = name;
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
