package com.example.missitios;

import java.util.ArrayList;
import java.util.List;

public class SitiosVector implements Sitios {

    protected List<Sitio> vectorSitios= ejemploSitios();

    public SitiosVector() {
        vectorSitios = ejemploSitios();
    }
    public Sitio elemento(int id) {
        return vectorSitios.get(id);
    }

    public void annade(Sitio sitio) {
        vectorSitios.add(sitio);
    }

    public int nuevo() {
        Sitio sitio = new Sitio();
        vectorSitios.add(sitio);
        return vectorSitios.size()-1;
    }

    public void borrar(int id) {
        vectorSitios.remove(id);
    }

    public int tamanno() {
        return vectorSitios.size();
    }

    public void actualiza(int id, Sitio sitio) {
        vectorSitios.set(id, sitio);
    }

    public static ArrayList<Sitio> ejemploSitios() {

        ArrayList<Sitio> sitios = new ArrayList<Sitio>();

        //Añadimos a la lista nuestros sitios favoritos de ejemplo

        sitios.add(new Sitio("Museo de Bellas Artes de Asturias", "C/ Santa Ana, 1, 33003, Oviedo, Asturias", -5.844393, 43.362149,
                TipoSitio.MUSEO, "985213061", "http://museobbaa.com","Imprescindible para los amantes de la pintura", 5));

        //Escribimos tantas sentencias como la anterior, como sitios queramos introducir

        return sitios;

    }
}