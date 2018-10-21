package com.example.vitor.a04_calculadora_area;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class trianguloResult implements Serializable {


    private double altura;
    private double comprimento;

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public void setComprimento(double comprimento)
    {
        this.comprimento = comprimento;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public double getComprimento()
    {
        return this.comprimento;
    }

    public String getResultado(){

        double resultado = (this.comprimento * this.altura)/2;
        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);
        return format.format(resultado);

    }

}
