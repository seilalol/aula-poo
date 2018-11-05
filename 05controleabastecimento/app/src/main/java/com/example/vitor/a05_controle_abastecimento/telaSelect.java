package com.example.vitor.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class telaSelect extends AppCompatActivity {
    private ArrayList<Posto> totalPostos;
    private abastecimentoAdapter postoAdapter;
    private RecyclerView rvTotalPostos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        totalPostos = new ArrayList<Posto>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_select);
        this.rvTotalPostos = findViewById(R.id.rvTotalPostos);
        this.postoAdapter = new abastecimentoAdapter();
        this.postoAdapter.listaAvaliacoes = this.totalPostos;
        rvTotalPostos.setAdapter(this.postoAdapter);
        rvTotalPostos.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));

    }

    public void criar(View view){

       Intent telaCriar = new Intent(this.getApplicationContext(), telaCriarPosto.class);
       startActivity(telaCriar);
        try {
            Posto novo = (Posto) getIntent().getSerializableExtra("Objeto");
            this.postoAdapter.listaAvaliacoes.add(novo);
            this.postoAdapter.notifyDataSetChanged();
        }catch (Exception e){}




    }

}
