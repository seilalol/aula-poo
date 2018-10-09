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
        EditText massa,distancia,tempo;

        TextView result;


        Button calcular = findViewById(R.id.button9);

        result = findViewById(R.id.resultado);

        massa=findViewById(R.id.massa);
        String massaDigi = massa.getText().toString();
        distancia=findViewById(R.id.distancia);
        tempo=findViewById(R.id.tempo);


            massa.setVisibility(View.VISIBLE);
            calcular.setVisibility(View.VISIBLE);


    }
}
