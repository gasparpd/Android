package com.example.proyectohilo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText entrada;
    private TextView salida;
    private Button btn_calcular;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = findViewById(R.id.salida);
        btn_calcular = findViewById(R.id.btn_calculo);
        entrada = findViewById(R.id.entrada);
    }

    public void calcularOperacion(View view) {
        int n =
                Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        long resultado = factorial(n);
        salida.append(resultado + "\n");
    }

    /*public long factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }*/

    class MiTarea extends AsyncTask<Integer, Integer, Long> {
        private ProgressDialog progreso;

        @Override
        protected void onPreExecute() {
            progreso = new ProgressDialog(MainActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            progreso.setMessage("Calculando");
            progreso.setCancelable(false);
            progreso.setMax(100);
            progreso.setProgress(0);
            progreso.show();
        }

        @Override
        protected Long doInBackground(Integer... n) {
            long resultado = 1;
            for (int i = 1; i <= n[0]; i++) {
                resultado *= i;
            }
            return resultado;
        }

        @Override
        protected void onProgressUpdate(Integer... porc) {
            progreso.setProgress(porc[0]);
        }

        @Override
        protected void onPostExecute(Long resul) {
            // Cerramos la ventana de progreso
            progreso.dismiss();
            salida.append(resul + "\n");
        }

    }
}