package com.example.proyectohilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.entrada);
        salida = findViewById(R.id.salida);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        MiHilo hilo = new MiHilo(n);
        hilo.start();
    }

    public long factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
            SystemClock.sleep(1000);
        }
        return resultado;
    }

    class MiHilo extends Thread{
        private int n;
        private long resultado;

        public MiHilo(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            resultado = factorial(n);
            runOnUiThread(new Runnable() {
                @Override public void run() {
                    salida.append(resultado + "\n");
                }
            });
        }
    }
}