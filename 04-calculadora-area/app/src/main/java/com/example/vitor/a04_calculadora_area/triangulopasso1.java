package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class triangulopasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulopasso1);
    }

    public void calcularTri(View ObjetoClicado){

        EditText altura,comprimento;

        altura = findViewById(R.id.altura);
        comprimento = findViewById(R.id.base);

        trianguloResult calcular = new trianguloResult();
        Intent calcularTriangulo = new Intent(this.getApplicationContext(),triangulopassofinal.class);
        try{
            calcular.setAltura(Double.parseDouble((altura.getText().toString())));
            calcular.setComprimento(Double.parseDouble(comprimento.getText().toString()));

            calcularTriangulo.putExtra("Objeto",(Serializable) calcular);

            this.startActivity(calcularTriangulo);
        }
        catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
        }

    }

}
