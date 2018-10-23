package com.example.vitor.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }

    public void avancar(View objeto){

        RadioGroup opcoes = findViewById(R.id.opcoes); //A partir daqui ao clicar no botão verifica qual opção foi selecionada e cria a intent pra tal, iniciando a proxima activity

        if(opcoes.getCheckedRadioButtonId() == R.id.triangulo){

            Intent trianguloCal = new Intent(this.getApplicationContext(), triangulopasso1.class);
            startActivity(trianguloCal);

        }if(opcoes.getCheckedRadioButtonId() == R.id.retangulo){

            Intent retanguloCal = new Intent(this.getApplicationContext(), retangulopasso1.class);
            startActivity(retanguloCal);

        }if(opcoes.getCheckedRadioButtonId() == R.id.circulo){
            Intent circuloCal = new Intent(this.getApplicationContext(), circulopasso1.class);
            startActivity(circuloCal);
        }

    }

}
