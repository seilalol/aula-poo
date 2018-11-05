package com.example.vitor.a05_controle_abastecimento;

import java.io.Serializable;

public class Posto implements Serializable {

    private String posto;
    private String data;
    private double kmAtual;
    private double litrosAbastecidos;


    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(double kmAtual) {
        this.kmAtual = kmAtual;
    }

    public double getLitrosAbastecidos() {
        return litrosAbastecidos;
    }

    public void setLitrosAbastecidos(double litrosAbastecidos) {
        this.litrosAbastecidos = litrosAbastecidos;
    }
}
