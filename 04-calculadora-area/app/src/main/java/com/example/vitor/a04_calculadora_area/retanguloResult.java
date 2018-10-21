package com.example.vitor.a04_calculadora_area;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class retanguloResult implements Serializable {

    private double comprimento;
    private double altura;


    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getResultado(){
        double resultado = this.altura * this.comprimento;
        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);
        return format.format(resultado);
    }

}
