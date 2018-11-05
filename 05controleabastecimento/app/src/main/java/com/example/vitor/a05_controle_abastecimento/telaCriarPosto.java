package com.example.vitor.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class telaCriarPosto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_criar_posto);
    }

    public void salvar(View view) {
        try {
            EditText kmAtual, Litros, data;
            Spinner spinner_1 = findViewById(R.id.spinner);
            List<String> list = new ArrayList<String>();
            list.add("Ipiranga");
            list.add("Shell");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_1.setAdapter(adapter);

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

            abastecimentoDAO salvar = new abastecimentoDAO();



            if(abastecimentoDAO.salvar(this.getApplicationContext(), novo)==true) {
                setResult(1);
                finish();
            }

        } catch (Exception e) {


        }


    }
}
