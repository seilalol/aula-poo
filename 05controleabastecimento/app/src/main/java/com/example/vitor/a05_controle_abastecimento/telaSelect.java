package com.example.vitor.a05_controle_abastecimento;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class telaSelect extends AppCompatActivity {
    private abastecimentoAdapter postoAdapter;
    private RecyclerView rvTotalPostos;
    private final int RC_ADICIONAR_POSTO = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_select); //Daqui a baixo ativa as listas, e inflando elas no xml
        abastecimentoDAO start = new abastecimentoDAO();

        this.rvTotalPostos = findViewById(R.id.rvTotalPostos);
        this.postoAdapter = new abastecimentoAdapter();

        this.postoAdapter.listaPostos = abastecimentoDAO.getLista(this.getApplicationContext());
        rvTotalPostos.setAdapter(this.postoAdapter);

        rvTotalPostos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

    }


    public void criarNovo(View Objeto) { //Cria um novo objeto passando a km do objeto anterior
        try {
            Intent telaCriar = new Intent(this.getApplicationContext(), telaCriarPosto.class);
            if (this.postoAdapter.listaPostos.size() == 0) {
                telaCriar.putExtra("kmAtual", 0.0);
            }
            if (this.postoAdapter.listaPostos.size() > 0) {
                double kmatual1 = this.postoAdapter.listaPostos.get(this.postoAdapter.listaPostos.size() - 1).getKmAtual();
                telaCriar.putExtra("kmAtual", kmatual1);
            }
            startActivityForResult(telaCriar, RC_ADICIONAR_POSTO);
        } catch (Exception e) {
        }

    }

    public void voltar(View Objeto){ //Volta ao main
        setResult(1);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Atualiza as gavetas
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_ADICIONAR_POSTO || resultCode == 1) {

            this.postoAdapter.notifyDataSetChanged();
        }

    }
}
