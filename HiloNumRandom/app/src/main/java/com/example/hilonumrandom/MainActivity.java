package com.example.hilonumrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView salida;
    private Button btn_calcular;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = findViewById(R.id.salida);
        btn_calcular = findViewById(R.id.btn_calculo);
    }

    public void calcularOperacion(View view) {
        salida.setText("");
        btn_calcular.setEnabled(false);

        MiHilo hilo = new MiHilo();
        hilo.start();
    }

    class MiHilo extends Thread {
        private int random;

        public MiHilo() {
            this.random = (int) Math.floor(Math.random() * 10);
        }

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (cont = 0 ; cont < 5; cont++) {
                        salida.append(Integer.toString(random));
                        SystemClock.sleep(500);
                        random = (int) Math.floor(Math.random() * 10);
                    }
                    btn_calcular.setEnabled(true);
                }
            });
        }
    }
}
