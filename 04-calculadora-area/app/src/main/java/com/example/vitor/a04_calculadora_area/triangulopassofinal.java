package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class triangulopassofinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulopassofinal);
        trianguloResult calcular = (trianguloResult) this.getIntent().getSerializableExtra("Objeto");
        TextView resulta = findViewById(R.id.resultadoT);

        resulta.setText("Area: " + calcular.getResultado() + "m²");

    }

    public void voltarT(View objeto){

        Intent voltarMenu = new Intent(this,MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}
