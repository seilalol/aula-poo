package com.example.vitor.a05_controle_abastecimento;

import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class telaCriarPosto extends AppCompatActivity {

    Spinner spinner_1;
    List<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_criar_posto);
        this.spinner_1 = findViewById(R.id.spinner);

        this.list.add("Ipiranga");
        this.list.add("Shell");
        this.list.add("Texaco");
        this.list.add("Petrobas");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner_1.setAdapter(adapter);


    }

    public void salvar(View view) { //Faz as conversões necessarias e salva no arquivo DAO
        try {
            abastecimentoDAO salvar = new abastecimentoDAO();

            EditText kmAtual, Litros, data;

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
            novo.setPosto(this.list.get(this.spinner_1.getSelectedItemPosition()));
            requesPermission();

                GPSProvider g = new GPSProvider(getApplicationContext());
                Location l = g.getLocation();

                    novo.setCoordenadas(l.getLatitude() + "|" + l.getLongitude()+"");

            double kmAntigo = this.getIntent().getDoubleExtra("kmAtual",0); //So salva se o kmAntigo for menor que o km atual
            if (kmAntigo < kmDouble || kmAntigo == 0) {
                if (abastecimentoDAO.salvar(this.getApplicationContext(), novo) == true) {
                    setResult(1);
                    finish();
                }
            }else {
                    kmAtual.setError("Precisa ser maior que o KM anterior.");

                }

        } catch (Exception e) {


        }


    }
    public void requesPermission(){

        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
    }
}
