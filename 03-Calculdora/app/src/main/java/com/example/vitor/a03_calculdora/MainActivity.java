package com.example.vitor.a03_calculdora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Go(View elementoClicaco)
    {
        CheckBox peso, velMed,MRU;
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        MRU = findViewById(R.id.MRU);
        int naopode=0;
        if(peso.isChecked()){
            naopode+=1;
        }if(velMed.isChecked()){
            naopode+=1;
        }if(MRU.isChecked()){
        naopode+=1;
    }
        if(MRU.isChecked() && naopode<=1) {

            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText xinicial, tempo,velocidade;

            velocidade = findViewById(R.id.vel);
            xinicial = findViewById(R.id.x0);
            tempo = findViewById(R.id.tempo);

            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            MRU.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            xinicial.setVisibility(View.VISIBLE);
            tempo.setVisibility(View.VISIBLE);
            velocidade.setVisibility(View.VISIBLE);


        }if(velMed.isChecked() && naopode<=1) {

            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText distancia, tempo;

            distancia = findViewById(R.id.distancia);
            tempo = findViewById(R.id.tempo);

            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            MRU.setVisibility(View.INVISIBLE);
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
            MRU.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);

        }else if(naopode>1){
            Toast mensagemErro = Toast.makeText(this, "Não é possivel selecionar mais de 1 checkbox", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }
    public void voltar(View elementoClicado){
        CheckBox peso, velMed, MRU;

        EditText distancia, tempo,vel ,x0;
        EditText mass = findViewById(R.id.massa);
        distancia = findViewById(R.id.distancia);
        tempo = findViewById(R.id.tempo);
        MRU = findViewById(R.id.MRU);
        x0 = findViewById(R.id.x0);
        peso = findViewById(R.id.peso);
        vel= findViewById(R.id.vel);
        velMed = findViewById(R.id.velocidade);
        Button calcular = findViewById(R.id.calcular);

        Button go = findViewById(R.id.Go);
        Button voltar = findViewById(R.id.voltar);
        TextView result = findViewById(R.id.resultado);

        mass.setText("");
        distancia.setText("");
        tempo.setText("");
        result.setText("");
        vel.setText("");
        x0.setText("");

        MRU.setVisibility(View.VISIBLE);
        x0.setVisibility(View.INVISIBLE);
        peso.setVisibility(View.VISIBLE);
        velMed.setVisibility(View.VISIBLE);
        go.setVisibility(View.VISIBLE);
        voltar.setVisibility(View.INVISIBLE);
        distancia.setVisibility(View.INVISIBLE);
        tempo.setVisibility(View.INVISIBLE);
        mass.setVisibility(View.INVISIBLE);
        vel.setVisibility(View.INVISIBLE);
        calcular.setVisibility(View.INVISIBLE);
        result.setVisibility(View.VISIBLE);

    }

    public void calcular(View elementoClicado){
        CheckBox peso, velMed,MRU;
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        MRU = findViewById(R.id.MRU);

        if(MRU.isChecked()) {
            EditText xinicial, tempo , velocidade;

            xinicial = findViewById(R.id.x0);
            tempo = findViewById(R.id.tempo);
            velocidade = findViewById(R.id.vel);

            String x0Digitada = xinicial.getText().toString();
            String tempDigitado = tempo.getText().toString();
            String velDigitada = velocidade.getText().toString();

            if(x0Digitada.equals("")  || tempDigitado.equals("") ||  velDigitada.equals("")){
                tempo.setError("Informe o tempo");
                xinicial.setError("Informe a distancia inicial");
                velocidade.setError("Informe a velocidade");
                return;
            }

            try{
                double tempoDouble = Double.parseDouble(tempDigitado);
                double x0Double = Double.parseDouble(x0Digitada);
                double velDouble = Double.parseDouble(velDigitada);

                double resultado =  x0Double + (velDouble*tempoDouble);

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + " metros.");
                result.setVisibility(View.VISIBLE);

            }catch (Exception e){

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }

        }if(velMed.isChecked()) {
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
