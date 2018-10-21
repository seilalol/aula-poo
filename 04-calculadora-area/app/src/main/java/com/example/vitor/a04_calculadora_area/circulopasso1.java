package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class circulopasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulopasso1);
    }

    public void calcularCir(View ObjetoClicado){

        EditText raio;

        raio = findViewById(R.id.raio);

        circuloResult calcular = new circuloResult();
        Intent calcularCirculo = new Intent(this.getApplicationContext(), circulopassofinal.class);
        try{
            calcular.setRaio(Double.parseDouble((raio.getText().toString())));

            calcularCirculo.putExtra("Objeto3",(Serializable) calcular);

            this.startActivity(calcularCirculo);
        }
        catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
        }

    }
}
