package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class retangulopassofinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulopassofinal);

        retanguloResult calcular = (retanguloResult) this.getIntent().getSerializableExtra("Objeto2"); //Recebe o objeto onde tem todos os atributos e que faz o calculo.

        TextView baseR = findViewById(R.id.baseR),alturaR = findViewById(R.id.alturaR);
        TextView resultadoR = findViewById(R.id.resultR);

        resultadoR.setText("Area: " + calcular.getResultado() + "m²"); //Troca as variaveis na referencia ao xml para mostrar no aplicativo
        alturaR.setText("Altura: " + calcular.getAltura());
        baseR.setText("Base: " + calcular.getComprimento());


    }

    public void voltarR(View objeto){ //Função do botão para voltar ao menu

        Intent voltarMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}

