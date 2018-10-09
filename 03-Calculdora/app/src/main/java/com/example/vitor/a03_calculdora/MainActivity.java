package com.example.vitor.a03_calculdora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Go(View elementoClicaco)
    {
        CheckBox peso, velMed;
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        int naopode=0;
        if(peso.isChecked()){
            naopode+=1;
        }if(velMed.isChecked()){
            naopode+=1;
        }

        if(velMed.isChecked() && naopode<=1) {
            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText distancia, tempo;

            distancia = findViewById(R.id.distancia);
            tempo = findViewById(R.id.tempo);

            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            distancia.setVisibility(View.VISIBLE);
            tempo.setVisibility(View.VISIBLE);


        }if(peso.isChecked() && naopode<=1) {
            Button calc = findViewById(R.id.calcular);
            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);

            EditText mass = findViewById(R.id.massa);

            mass.setVisibility(View.VISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);

        }else if(naopode>1){
            Toast mensagemErro = Toast.makeText(this, "Não é possivel selecionar mais de 1 checkbox", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }
    public void voltar(View elementoClicado){
        CheckBox peso, velMed;
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        peso.setVisibility(View.VISIBLE);
        velMed.setVisibility(View.VISIBLE);
        EditText distancia, tempo;

        Button go = findViewById(R.id.Go);
        go.setVisibility(View.VISIBLE);
        Button voltar = findViewById(R.id.voltar);
        voltar.setVisibility(View.INVISIBLE);

        distancia = findViewById(R.id.distancia);
        tempo = findViewById(R.id.tempo);
        distancia.setVisibility(View.INVISIBLE);
        tempo.setVisibility(View.INVISIBLE);

        EditText mass = findViewById(R.id.massa);
        mass.setVisibility(View.INVISIBLE);

        mass.setText("");
        distancia.setText("");
        tempo.setText("");
        Button calcular = findViewById(R.id.calcular);
        calcular.setVisibility(View.INVISIBLE);

        TextView result = findViewById(R.id.resultado);
        result.setText("");
        result.setVisibility(View.VISIBLE);

    }

    public void calcular(View elementoClicado){
        CheckBox peso, velMed;
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);

        if(velMed.isChecked()) {
            EditText distancia, tempo;

            distancia = findViewById(R.id.distancia);
            tempo = findViewById(R.id.tempo);

            String distDigitada = distancia.getText().toString();
            String tempDigitado = tempo.getText().toString();

            if(distDigitada.equals("")  || tempDigitado.equals("")){
                tempo.setError("Informe o tempo");
                distancia.setError("Informe a distancia");
                return;
            }

            try{
                double tempoDouble = Double.parseDouble(tempDigitado);
                double distDouble = Double.parseDouble(distDigitada);

                double resultado =  distDouble/tempoDouble;

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + "m/s.");
                result.setVisibility(View.VISIBLE);

            }catch (Exception e){

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }


        }if(peso.isChecked()) {
            EditText mass = findViewById(R.id.massa);
            mass = findViewById(R.id.massa);

            String massaDigitada = mass.getText().toString();

            if(massaDigitada.equals("")){
                mass.setError("Informe o peso");
                return;
            }

            try{
                double massaDouble = Double.parseDouble(massaDigitada);

                double resultado =  massaDouble*9.8;

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + "N");
                result.setVisibility(View.VISIBLE);

            }catch (Exception e){

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }

        }


    }


}
