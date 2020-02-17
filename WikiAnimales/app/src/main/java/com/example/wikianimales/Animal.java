package com.example.wikianimales;

public class Animal {

    private String titulo;
    private int imagen;
    private String comentario;

    public Animal(String titulo, int imagen, String comentario) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.comentario = comentario;
    }

    public Animal() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
