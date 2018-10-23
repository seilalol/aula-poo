package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class triangulopassofinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulopassofinal);

        trianguloResult calcular = (trianguloResult) this.getIntent().getSerializableExtra("Objeto"); //Recebe o objeto onde tem todos os atributos e que faz o calculo.

        TextView baseT = findViewById(R.id.baseT),alturaT=findViewById(R.id.alturaT);
        TextView resulta = findViewById(R.id.resultadoT);

        resulta.setText("Area: " + calcular.getResultado() + "m²"); //Troca as variaveis na referencia ao xml para mostrar no aplicativo
        alturaT.setText("Altura: "+ calcular.getAltura());
        baseT.setText("Base: "+ calcular.getComprimento());

    }

    public void voltarT(View objeto){ //Função do botão para voltar ao menu

        Intent voltarMenu = new Intent(this,MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}
