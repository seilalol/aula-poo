package com.example.vitor.a04_calculadora_area;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circuloResult implements Serializable {

    private double raio;


    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public String getResultado(){

        double resultado = Math.pow(this.raio,2) * Math.PI;
        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);

        return format.format(resultado);

    }
}
