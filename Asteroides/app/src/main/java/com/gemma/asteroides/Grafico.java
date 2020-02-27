package com.gemma.asteroides;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable; //Imagen que dibujaremos
    private int cenX, cenY; //Posición del centro del gráfico
    private int ancho, alto; //Dimensiones de la imagen
    private double incX, incY; //Velocidad desplazamiento
    private double angulo, rotacion;//Ángulo y velocidad rotación
    private int radioColision; //Para determinar colisión
    private int xAnterior, yAnterior; //Posición anterior
    private int radioInval; //Radio usado en view.invalidate
    private View view; //Usada en view.ivalidate

    public Grafico(View view, Drawable drawable) {
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto + ancho) / 4;
        radioInval = (int) Math.hypot(ancho / 2, alto / 2);
    }

    public void dibujaGrafico(Canvas canvas) {
        canvas.save();
        int x = cenX - ancho / 2;
        int y = cenY - alto / 2;
        drawable.setBounds(x, y, x + ancho, y + alto);
        canvas.save();
        canvas.rotate((float) angulo, cenX, cenY);
        drawable.draw(canvas);
        canvas.restore();
        view.invalidate(cenX - radioInval, cenY - radioInval, cenX +
                radioInval, cenY + radioInval);
        xAnterior = cenX;
        yAnterior = cenY;
    }

    public void incrementaPos(double factor) {
        cenX += incX * factor;
        cenY += incY * factor;
        angulo += rotacion * factor;
        // Si salimos de la pantalla, corregimos la posición
        if (cenX < 0) {
            cenX = view.getWidth();
        }
        if (cenX > view.getWidth()) {
            cenX = 0;
        }
        if (cenY < 0) {
            cenY = view.getHeight();
        }
        if (cenY > view.getHeight()) {
            cenY = 0;
        }
    }

    public double distancia(Grafico g) {
        return Math.hypot(cenX - g.cenX, cenY - g.cenY);
    }

    public boolean verificaColision(Grafico g) {
        return (distancia(g) < (radioColision + g.radioColision));
    }
}


