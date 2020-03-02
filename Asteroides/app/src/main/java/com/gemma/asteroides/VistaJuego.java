package com.gemma.asteroides;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class VistaJuego extends View {
    /*ASTEROIDES*/
    private List<Grafico> asteroides; // Lista con los Asteroides
    private int numAsteroides = 10; // Número inicial de asteroides
    private int numFragmentos = 3; // Fragmentos en que se divide

    // //// NAVE //////
    private Grafico nave;// Gráfico de la nave
    private int giroNave; // Incremento de dirección
    private float aceleracionNave; // aumento de velocidad
    private static final int MAX_VELOCIDAD_NAVE = 20;
    // Incremento estándar de giro y aceleración
    private static final int PASO_GIRO_NAVE = 5;
    private static final float PASO_ACELERACION_NAVE = 0.5f;

    // //// THREAD Y TIEMPO //////
    // Thread encargado de procesar el juego
    private ThreadJuego thread = new ThreadJuego();
    // Cada cuanto queremos procesar cambios (ms)
    private static int PERIODO_PROCESO = 50;
    // Cuando se realizó el último proceso
    private long ultimoProceso = 0;

    public VistaJuego(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Drawable drawableNave, drawableAsteroide, drawableMisil;

        drawableAsteroide = context.getResources().getDrawable(R.drawable.asteroide1);
        asteroides = new ArrayList<>();

        drawableNave = context.getResources().getDrawable(R.drawable.nave);
        nave = new Grafico(this, drawableNave);

        for (int i = 0; i < numAsteroides; i++) {
            Grafico asteroide = new Grafico(this, drawableAsteroide);
            asteroide.setIncX(Math.random() * 4 - 2);
            asteroide.setIncY(Math.random() * 4 - 2);
            asteroide.setAngulo((int) (Math.random() * 360));
            asteroide.setRotacion((int) (Math.random() * 8 - 4));
            asteroides.add(asteroide);
        }
    }

    @Override
    protected void onSizeChanged(int ancho, int alto, int
            ancho_anter, int alto_anter) {
        super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);

        /*Posicionamos la nave*/
        nave.setCenX((int) (Math.random() * ancho));
        nave.setCenY((int) (Math.random() * alto));

        /*Una vez que conocemos nuestro ancho y alto
        posicionamos los asteroides*/
        for (Grafico asteroide : asteroides) {
            do {
                asteroide.setCenX((int) (Math.random() * ancho));
                asteroide.setCenY((int) (Math.random() * alto));
            } while (asteroide.distancia(nave) < (ancho + alto) / 5);
        }

        ultimoProceso = System.currentTimeMillis();
        thread.start();
    }

    @Override
    synchronized protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Grafico asteroide : asteroides) {
            asteroide.dibujaGrafico(canvas);
            nave.dibujaGrafico(canvas);
        }
    }

    synchronized protected void actualizaFisica() {
        long ahora = System.currentTimeMillis();
        if (ultimoProceso + PERIODO_PROCESO > ahora) {
            return; // Salir si el periodo de proceso no se ha cumplido
        }
        // Para una ejecución en tiempo real calculamos el factor de movimiento
        double factorMov = (ahora - ultimoProceso) / PERIODO_PROCESO;
        ultimoProceso = ahora; // Para la próxima vez
        // Actualizamos velocidad y dirección de la nave a partir de
        // giroNave y aceleracionNave (según la entrada del jugador)
        nave.setAngulo((int) (nave.getAngulo() + giroNave * factorMov));
        double nIncX = nave.getIncX() + aceleracionNave *
                Math.cos(Math.toRadians(nave.getAngulo())) * factorMov;
        double nIncY = nave.getIncY() + aceleracionNave *
                Math.sin(Math.toRadians(nave.getAngulo())) * factorMov;
        // Actualizamos si el módulo de la velocidad no excede el máximo
        if (Math.hypot(nIncX, nIncY) <= MAX_VELOCIDAD_NAVE) {
            nave.setIncX(nIncX);
            nave.setIncY(nIncY);
        }
        // Actualizamos posiciones X e Y
        nave.incrementaPos(factorMov);
        for (Grafico asteroide : asteroides) {
            asteroide.incrementaPos(factorMov);
        }
    }

    class ThreadJuego extends Thread {
        @Override
        public void run() {
            while (true) {
                actualizaFisica();
            }
        }
    }
}
