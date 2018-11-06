package com.example.vitor.a05_controle_abastecimento;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    abastecimentoDAO dadosDao = new abastecimentoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try { //Calcula a autonomia
            if (abastecimentoDAO.getLista(this.getApplicationContext()).size() >= 2) {
                double autonomia = 0, km = 0, litros = 0;
                ArrayList<Posto> lista = dadosDao.getLista(this.getApplicationContext());
                if (lista.size() != 0) {
                    for (int i = 0; i < lista.size() - 1; i++) {
                        litros += lista.get(i).getLitrosAbastecidos();
                    }
                    km = lista.get(lista.size() - 1).getKmAtual() - lista.get(0).getKmAtual();
                    autonomia = km / litros;
                    TextView tvAutonomia = findViewById(R.id.autonomia);
                    tvAutonomia.setText("" + new DecimalFormat("##.##").format(autonomia));
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Quando voltar recalcula a autonomia
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (abastecimentoDAO.getLista(this.getApplicationContext()).size() >= 2) {
                double autonomia = 0, km = 0, litros = 0;
                ArrayList<Posto> lista = dadosDao.getLista(this.getApplicationContext());
                if (lista.size() != 0) {
                    for (int i = 0; i < lista.size() - 1; i++) {
                        litros += lista.get(i).getLitrosAbastecidos();
                    }
                    km = lista.get(lista.size() - 1).getKmAtual() - lista.get(0).getKmAtual();
                    autonomia = km / litros;
                    TextView tvAutonomia = findViewById(R.id.autonomia);
                    tvAutonomia.setText("" + new DecimalFormat("##.##").format(autonomia));
                }
            }
        } catch (Exception e) {
        }
    }

    public void next(View obj) {

        Intent proximaTela = new Intent(this.getApplicationContext(), telaSelect.class);
        startActivityForResult(proximaTela, 17);

    }
}

