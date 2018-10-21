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

        retanguloResult calcular = (retanguloResult) this.getIntent().getSerializableExtra("Objeto2");

        TextView resultadoR = findViewById(R.id.resultR);
        resultadoR.setText("Area: " + calcular.getResultado() + "m²");

    }

    public void voltarR(View objeto){

        Intent voltarMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}

