package com.example.vitor.a03_calculdora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Go(View elementoClicaco)    { // Quando selecionar uma checkBox e clicar go ira iniciar esta função
        CheckBox peso, velMed,MRU,IMC;
        IMC = findViewById(R.id.IMC);
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        MRU = findViewById(R.id.MRU);
        int naopode=0;

        if(peso.isChecked()){ //Nessa parte é checado se tem mais de uma checkbox marcado, se estiver soma + 1 no naopode, e se for maior que 1, ele não deixa entrar na condição
            naopode+=1;
        }if(velMed.isChecked()){
            naopode+=1;
        }if(MRU.isChecked()){//
        naopode+=1;
        }if(IMC.isChecked()){//
            naopode+=1;
        }
        //Verifica qual checkbox está ativada e se tiver, ativa as visibilidades das variaveis que utilizei
        if(IMC.isChecked() && naopode<=1) {

            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText mass, altura;

            altura = findViewById(R.id.Altura);
            mass = findViewById(R.id.massa);

            IMC.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            MRU.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            mass.setVisibility(View.VISIBLE);
            altura.setVisibility(View.VISIBLE);

        }if(MRU.isChecked() && naopode<=1) {

            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText xinicial, tempo,velocidade;

            velocidade = findViewById(R.id.vel);
            xinicial = findViewById(R.id.x0);
            tempo = findViewById(R.id.tempo);

            IMC.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            MRU.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            xinicial.setVisibility(View.VISIBLE);
            tempo.setVisibility(View.VISIBLE);
            velocidade.setVisibility(View.VISIBLE);

        }if(velMed.isChecked() && naopode<=1) {//Verifica qual checkbox está ativada e se tiver, ativa as visibilidades das variaveis que utilizei

            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);
            Button calc = findViewById(R.id.calcular);

            EditText distancia, tempo;

            distancia = findViewById(R.id.distancia);
            tempo = findViewById(R.id.tempo);

            IMC.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);
            MRU.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            distancia.setVisibility(View.VISIBLE);
            tempo.setVisibility(View.VISIBLE);

        }if(peso.isChecked() && naopode<=1) {//Verifica qual checkbox está ativada e se tiver, ativa as visibilidades das variaveis que utilizei

            Button calc = findViewById(R.id.calcular);
            Button go = findViewById(R.id.Go);
            Button voltar = findViewById(R.id.voltar);

            EditText mass = findViewById(R.id.massa);

            IMC.setVisibility(View.INVISIBLE);
            mass.setVisibility(View.VISIBLE);
            go.setVisibility(View.INVISIBLE);
            voltar.setVisibility(View.VISIBLE);
            calc.setVisibility(View.VISIBLE);
            MRU.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            velMed.setVisibility(View.INVISIBLE);

        }else{ //Caso seja maior, aparece uma mensagem de erro no canto inferior central
            Toast mensagemErro = Toast.makeText(this, "Não é possivel continuar", Toast.LENGTH_LONG);
            mensagemErro.show();
            return;
        }

        TextView textoInicio,textoConta;
        ImageView einstein;

        einstein = findViewById(R.id.einsteinl);

        textoConta = findViewById(R.id.textoConta);
        textoInicio = findViewById(R.id.inicioTexto);

        textoInicio.setVisibility(View.INVISIBLE);
        textoConta.setVisibility(View.VISIBLE);

        einstein.setVisibility(View.VISIBLE);

    }
    public void voltar(View elementoClicado){ //Volta para a tela inicial das checkbox, identifica todas as variaveis e seta elas para invisivel ou visivel dependendo da necessidade
        CheckBox peso, velMed, MRU,IMC;       //e seta para os valores inicias (vazio) das caixas de texto.
        TextView textoInicio,textoConta;
        ImageView einstein;

        einstein = findViewById(R.id.einsteinl);
        textoConta = findViewById(R.id.textoConta);
        textoInicio = findViewById(R.id.inicioTexto);

        EditText distancia, tempo,vel ,x0,altura;
        EditText mass = findViewById(R.id.massa);
        altura = findViewById(R.id.Altura);
        IMC = findViewById(R.id.IMC);
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

        altura.setText("");
        mass.setText("");
        distancia.setText("");
        tempo.setText("");
        result.setText("");
        vel.setText("");
        x0.setText("");

        altura.setVisibility(View.INVISIBLE);
        IMC.setVisibility(View.VISIBLE);
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
        textoInicio.setVisibility(View.VISIBLE);
        textoConta.setVisibility(View.INVISIBLE);
        einstein.setVisibility(View.INVISIBLE);

    }
    public void calcular(View elementoClicado){ //Faz o calculo dependendo de qual checkbox estiver marcada
        CheckBox peso, velMed,MRU,IMC;
        IMC = findViewById(R.id.IMC);
        peso = findViewById(R.id.peso);
        velMed = findViewById(R.id.velocidade);
        MRU = findViewById(R.id.MRU);

        if(MRU.isChecked()) { //Movimento retilineo uniforme
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
                //Formula: Distancia = DistanciaInicial + Velocidade * Tempo
                double resultado =  x0Double + (velDouble*tempoDouble);

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + " metros.");
                result.setVisibility(View.VISIBLE);

            }catch (Exception e){

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }

        }if(velMed.isChecked()) { //Velocidade media
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
                //Formula: velocidade media = distancia percorrida/ tempo
                double resultado =  distDouble/tempoDouble;

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + "m/s.");
                result.setVisibility(View.VISIBLE);

            }catch (Exception e){

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }

        }if(peso.isChecked()) { //Peso em N
            EditText mass = findViewById(R.id.massa);
            mass = findViewById(R.id.massa);

            String massaDigitada = mass.getText().toString();

            if (massaDigitada.equals("")) {
                mass.setError("Informe o peso");
                return;
            }

            try {
                double massaDouble = Double.parseDouble(massaDigitada);
                //Formula:  Peso = massa * gravidade
                double resultado = massaDouble * 9.8;

                TextView result = findViewById(R.id.resultado);

                result.setText("Resultado= " + resultado + "N");
                result.setVisibility(View.VISIBLE);

            } catch (Exception e) {

                Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                mensagemErro.show();

            }
        }if(IMC.isChecked()) { //Peso em N
                EditText mass,altura;
                altura = findViewById(R.id.Altura);
                mass = findViewById(R.id.massa);

                String massaDigitada = mass.getText().toString();
                String alturaDigitada = altura.getText().toString();

                if(massaDigitada.equals("") || alturaDigitada.equals("")){
                    mass.setError("Informe o peso");
                    altura.setError("Informe a altura");

                    return;
                }

                try{
                    double massaDouble = Double.parseDouble(massaDigitada);
                    double alturaDouble = Double.parseDouble(alturaDigitada);
                    //Formula:  IMC = peso/altura*altura
                    double resultado =  massaDouble/(alturaDouble*alturaDouble);

                    TextView result = findViewById(R.id.resultado);

                    result.setText("Resultado= " + resultado);
                    result.setVisibility(View.VISIBLE);

                }catch (Exception e){

                    Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu, evite letras", Toast.LENGTH_LONG);
                    mensagemErro.show();

                }

        }

    }

}
