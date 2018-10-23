package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class retangulopasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulopasso1);
    }

    public void calcularRet(View ObjetoClicado){

        EditText altura,comprimento;

        altura = findViewById(R.id.altura2);
        comprimento = findViewById(R.id.base2);

        retanguloResult calcular = new retanguloResult(); //Recebe da tela os atributos
        Intent calcularRetangulo = new Intent(this.getApplicationContext(), retangulopassofinal.class); //Intent da proxima activity

        try{ //Garante não fechar o programa se houver erros
            calcular.setAltura(Double.parseDouble((altura.getText().toString())));
            calcular.setComprimento(Double.parseDouble(comprimento.getText().toString()));

            calcularRetangulo.putExtra("Objeto2",(Serializable) calcular);//Passa a classe na qual realiza todos os calculos e contem os atributos com um nome para ser recebido
                                                                                //no proximo intent

            this.startActivity(calcularRetangulo); //Inicia a proxima tela
        }
        catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
        }

    }
}
