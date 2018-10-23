package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class circulopassofinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulopassofinal);

        circuloResult calcular = (circuloResult) this.getIntent().getSerializableExtra("Objeto3"); //Recebe o objeto onde tem todos os atributos e que faz o calculo.

        TextView raio = findViewById(R.id.raioC);
        TextView resultadoC = findViewById(R.id.resultC);

        resultadoC.setText("Area: " + calcular.getResultado() + "m²"); //Troca as variaveis na referencia ao xml para mostrar no aplicativo
        raio.setText("Raio: " + calcular.getRaio());



    }

    public void voltarC(View objeto){ //Função do botão para voltar ao menu

        Intent voltarMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}
