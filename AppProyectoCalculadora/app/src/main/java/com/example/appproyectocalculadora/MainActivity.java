package com.example.appproyectocalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b_coma, b_suma, b_resta, b_mult, b_div, b_igual, b_retroceso, b_vaciar, b_cambiosigno;
    TextView tv_arriba, tv_parcial;
    double n1, n2;
    int op;
    String sParcial= "", sTotal= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        b_coma = findViewById(R.id.btn_coma);
        b_suma = findViewById(R.id.btn_suma);
        b_resta = findViewById(R.id.btn_cambiosig);
        b_mult = findViewById(R.id.btn_retroceso);
        b_div = findViewById(R.id.btn_div);
        b_igual = findViewById(R.id.btn_igual);
        b_retroceso = findViewById(R.id.btn_retroceso);
        b_vaciar = findViewById(R.id.btn_vaciar);
        b_cambiosigno = findViewById(R.id.btn_cambiosig);

        tv_arriba = findViewById(R.id.tv_cuenta);
        tv_parcial = findViewById(R.id.tv_parcial);

    }

    public void n0(View view){
        sParcial += "0";
        mostrarParcial();
    }

    public void n1(View view){
        sParcial += "1";
        mostrarParcial();
    }

    public void n2(View view){
        sParcial += "2";
        mostrarParcial();
    }

    public void n3(View view){
        sParcial += "3";
        mostrarParcial();
    }

    public void n4(View view){
        sParcial += "4";
        mostrarParcial();
    }

    public void n5(View view){
        sParcial += "5";
        mostrarParcial();
    }

    public void n6(View view){
        sParcial += "6";
        mostrarParcial();
    }

    public void n7(View view){
        sParcial += "7";
        mostrarParcial();
    }

    public void n8(View view){
        sParcial += "8";
        mostrarParcial();
    }

    public void n9(View view){
        sParcial += "9";
        mostrarParcial();
    }

    public void coma(View view){
        if (sParcial.endsWith(".")){
        }
        else{
            if(sParcial.equals("")){
                sParcial += "0.";
            }else {
                if(sParcial.contains(".")){

                }else{
                    sParcial += ".";
                }
            }
        }
        mostrarParcial();
    }

    public void suma(View view){
        if (!compruebaVacio() && !compruebaDobleOperacion()) {
            if (comprobarPrimeraOp()) {
                n1 = Double.parseDouble(sParcial);
                sTotal = sParcial + " +";
                vaciarParcial();
                mostrarTotal();
            } else {
                if (comprobarTrasIgual()) {
                    sTotal = n1 + " +";
                    mostrarTotal();
                } else {
                    if (comprobarSegundaOp()) {
                        primeraOperacionRecursiva();
                        sTotal += " +";
                        mostrarTotal();
                    } else {
                        n2 = Double.parseDouble(sParcial);
                        sTotal = sTotal + " " + sParcial + " +";
                        mostrarTotal();
                        n1 = n1 + n2;
                        sParcial = String.valueOf(n1);
                        mostrarParcial();
                        vaciarParcial();
                    }
                }
            }
        }
        op = 1;
    }

    public void resta(View view){
        if (!compruebaVacio() && !compruebaDobleOperacion()) {
            if (comprobarPrimeraOp()) {
                n1 = Double.parseDouble(sParcial);
                sTotal = sParcial + " -";
                vaciarParcial();
                mostrarTotal();
            } else {
                if (comprobarTrasIgual()) {
                    sTotal = n1 + " -";
                    mostrarTotal();
                } else {
                    if (comprobarSegundaOp()) {
                        primeraOperacionRecursiva();
                        sTotal += " -";
                        mostrarTotal();
                    } else {
                        n2 = Double.parseDouble(sParcial);
                        sTotal = sTotal + " " + sParcial + " -";
                        mostrarTotal();
                        n1 = n1 - n2;
                        sParcial = String.valueOf(n1);
                        mostrarParcial();
                        vaciarParcial();
                    }
                }
            }
        }
        op = 2;
    }

    public void mult(View view){
        if (!compruebaVacio() && !compruebaDobleOperacion()) {
            if (comprobarPrimeraOp()) {
                n1 = Double.parseDouble(sParcial);
                sTotal = sParcial + " x";
                vaciarParcial();
                mostrarTotal();
            } else {
                if (comprobarTrasIgual()) {
                    sTotal = n1 + " x";
                    mostrarTotal();
                } else {
                    if (comprobarSegundaOp()) {
                        primeraOperacionRecursiva();
                        sTotal += " x";
                        mostrarTotal();
                    } else {
                        n2 = Double.parseDouble(sParcial);
                        sTotal = sTotal + " " + sParcial + " x";
                        mostrarTotal();
                        n1 = n1 * n2;
                        sParcial = String.valueOf(n1);
                        mostrarParcial();
                        vaciarParcial();
                    }
                }
            }
        }

        op = 3;
        //Controlar primera operación
        //Si se hacen dos operaciones seguidas, sin pulsar igual, no hace la primera operación
    }

    public void div(View view){
        if (!compruebaVacio() && !compruebaDobleOperacion()) {
            if (comprobarPrimeraOp()) {
                n1 = Double.parseDouble(sParcial);
                sTotal = sParcial + " /";
                vaciarParcial();
                mostrarTotal();
            } else {
                if (comprobarTrasIgual()) {
                    sTotal = n1 + " /";
                    mostrarTotal();
                } else {
                    if (comprobarSegundaOp()) {
                        primeraOperacionRecursiva();
                        sTotal += " /";
                        mostrarTotal();
                    } else {
                        n2 = Double.parseDouble(sParcial);
                        sTotal = sTotal + " " + sParcial + " /";
                        mostrarTotal();
                        n1 = n1 / n2;
                        sParcial = String.valueOf(n1);
                        mostrarParcial();
                        vaciarParcial();
                    }
                }
            }
        }

        op = 4;
    }

    public void porcentaje(View view){
        if(!compruebaVacio() && !compruebaDobleOperacion()){
            if (comprobarPrimeraOp()) {
                n1 = Double.parseDouble(sParcial);
                sTotal = sParcial + " %";
                vaciarParcial();
                mostrarTotal();
            }else{
                if (comprobarTrasIgual()) {
                    sTotal = n1 + " %";
                    mostrarTotal();
                } else {
                    if (comprobarSegundaOp()) {
                        primeraOperacionRecursiva();
                        sTotal += " %";
                        mostrarTotal();
                    } else {
                        n2 = Double.parseDouble(sParcial);
                        sTotal = sTotal + " " + sParcial + " %";
                        mostrarTotal();
                        n1 = n1 / n2;
                        sParcial = String.valueOf(n1);
                        mostrarParcial();
                        vaciarParcial();
                    }
                }
            }
        }

        op = 5;
    }

    public void cambioSigno(View view){
        if (!compruebaVacio() && !compruebaDobleOperacion()) {
            if (comprobarTrasIgual()) {
                sParcial = String.valueOf(n1);
            }
            double aux = Double.parseDouble(sParcial);
            aux = -aux;
            sParcial = String.valueOf(aux);
            mostrarParcial();
        }
    }

    public void retroceder(View view){
        if(!compruebaVacio()){
            String aux  = (String) sParcial.subSequence(0, sParcial.length() - 1);
            sParcial = aux;
            mostrarParcial();
        }
    }

    public void vaciar(View view){
        n1 = 0; n2 = 0;
        vaciarParcial();
        mostrarParcial();
        vaciarTotal();
        mostrarTotal();
    }
    //Dos métodos para vaciar por individual las cadenas de Parcial o Total
    private void vaciarParcial() {
        sParcial = "";
    }

    private void vaciarTotal() {
        sTotal = "";
    }

    public void igual(View view){
        if(!comprobarSegundaOpVacio()){
            switch (op){
                case 1:
                    suma(view);
                    break;
                case 2:
                    resta(view);
                    break;
                case 3:
                    mult(view);
                    break;
                case 4:
                    div(view);
                    break;
                case 5:
                    porcentaje(view);
                    break;
            }
            vaciarTotal();
            mostrarTotal();
        }
    }

    public void primeraOperacionRecursiva(){
        switch (op){
            case 1:
                n2 = Double.parseDouble(sParcial);
                sTotal = sTotal + " " + sParcial;
                mostrarTotal();
                n1 = n1 + n2;
                sParcial = String.valueOf(n1);
                mostrarParcial();
                vaciarParcial();
                break;
            case 2:
                n2 = Double.parseDouble(sParcial);
                sTotal = sTotal + " " + sParcial;
                mostrarTotal();
                n1 = n1 - n2;
                sParcial = String.valueOf(n1);
                mostrarParcial();
                vaciarParcial();
                break;
            case 3:
                n2 = Double.parseDouble(sParcial);
                sTotal = sTotal + " " + sParcial;
                mostrarTotal();
                n1 = n1 * n2;
                sParcial = String.valueOf(n1);
                mostrarParcial();
                vaciarParcial();
                break;
            case 4:
                n2 = Double.parseDouble(sParcial);
                sTotal = sTotal + " " + sParcial;
                mostrarTotal();
                n1 = n1 / n2;
                sParcial = String.valueOf(n1);
                mostrarParcial();
                vaciarParcial();
                break;
            case 5:
                n2 = Double.parseDouble(sParcial);
                sTotal = sTotal +" " +sParcial;
                mostrarTotal();
                n1 = n1 / 100 * n2;
                sParcial = String.valueOf(n1);
                mostrarParcial();
                vaciarParcial();
                break;
        }
    }
    //Refresca la información del TextView Parcial
    public void mostrarParcial(){
        tv_parcial.setText(sParcial);
    }
    //refresca la información del TextView Total
    public void mostrarTotal(){
        tv_arriba.setText(sTotal);
    }
    /*Comprueba si es la primera vez que se pulsa el botón de la operación, ya que no tiene la misma funcionalidad
    * que si es la segunda o tercera vez.*/

    public boolean comprobarPrimeraOp (){
        if(n1 == 0 && n2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    /*Comprueba si se quieren realizar dos operaciones seguidas*/
    public boolean comprobarSegundaOp (){
        if (n1 != 0 && !sParcial.equals("")){
            return true;
        }
        else {
            return false;
        }
    }
    /*Controla que no se quiera realizar una operación sin haber metido un segundo número.
    * Lo utilizo en el método "igual"*/
    public boolean comprobarSegundaOpVacio (){
        if (n1 != 0 && n2 == 0 && sParcial.equals("")){
            return true;
        }
        else {
            return false;
        }
    }
    /*Comprueba si se quiere continuar una operación después de haber pulsado el botóni gual*/
    public boolean comprobarTrasIgual (){
        if(n1 != 0 && n2 != 0 && sTotal.equals("") && sParcial.equals("")){
            return true;
        }
        else{
            return false;
        }
    }
    /*
     *Con los dos siguientes métodos quiero controlar que no se puedan pulsar
     *dos veces un botón de operación, por ejemplo, o que el botón de retroceso
     *no intente borrar cuando no hay ningún numero en el parcial
    */
    public boolean compruebaVacio(){
        if(n1 == 0 && n2 == 0 && sTotal.equals("") && sParcial.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public boolean compruebaDobleOperacion(){
        if(sParcial.equals("")){
            return true;
        }
        return false;
    }
}
