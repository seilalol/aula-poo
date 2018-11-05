package com.example.vitor.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class telaCriarPosto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_criar_posto);
    }

    public void salvar(View view){
        try {
        EditText kmAtual,Litros,data;

        kmAtual = findViewById(R.id.kmAtualPosto);
        Litros = findViewById(R.id.litrosAtualPosto);
        data = findViewById(R.id.dataAtualPosto);

            String dataString = data.getText().toString();
            double litrosDouble = Double.parseDouble(Litros.getText().toString());
            double kmDouble = Double.parseDouble(kmAtual.getText().toString());

        Posto novo = new Posto();

        novo.setLitrosAbastecidos(litrosDouble);
        novo.setKmAtual(kmDouble);
        novo.setData(dataString);

        getIntent().putExtra("Objeto",novo);

        }catch(Exception e){


        }



    }
}
