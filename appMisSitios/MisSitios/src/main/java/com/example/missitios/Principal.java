package com.example.missitios;

public class Principal {

    public static void main(String[] main) {
        Sitios sitios=new SitiosVector();
        for(int i=0; i<sitios.tamanno();i++){
            System.out.println(sitios.elemento(i).toString());
        }
    }
}
