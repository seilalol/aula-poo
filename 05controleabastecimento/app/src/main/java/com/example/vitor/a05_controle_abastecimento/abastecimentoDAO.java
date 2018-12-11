package com.example.vitor.a05_controle_abastecimento;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class abastecimentoDAO {


    private static ArrayList<Posto> AL_CACHE = new ArrayList<>();
    private static final String NOME_ARQUIVO = "postosPronto.txt";
    public static boolean salvar(Context c, Posto aSerSalva){
        AL_CACHE.add(aSerSalva);
        String postoEmString = "";
        //Salvar tudo num string que vai ser escrita num arquivo, sendo cada linha um objeto do tipo posto
        postoEmString += aSerSalva.getData() + ";";
        postoEmString += aSerSalva.getLitrosAbastecidos() + ";";
        postoEmString += aSerSalva.getKmAtual() + ";";
        postoEmString += aSerSalva.getPosto() + ";";
        postoEmString += aSerSalva.getCoordenadas() + ";" + "\n";
        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write( postoEmString );
            escritor.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<Posto> getLista(Context c){//Recarrega o arquivo lindo linha por linha, e divindo as linhas em partes pra definir novamente os atributos
        AL_CACHE = new ArrayList<>();
        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);
            String linhaPosto = null;
            while((linhaPosto = leitorDeLinha.readLine()) != null){
                String[] partesDaLinha = linhaPosto.split(";");
                Posto daVez = new Posto();

                daVez.setData( partesDaLinha[0] );
                daVez.setLitrosAbastecidos(Double.parseDouble(partesDaLinha[1]));
                daVez.setKmAtual(Double.parseDouble(partesDaLinha[2]));
                daVez.setPosto( partesDaLinha[3] );
                daVez.setCoordenadas( partesDaLinha[4] );
                AL_CACHE.add(daVez);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AL_CACHE;
    }


}
