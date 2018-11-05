package com.example.vitor.a05_controle_abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class abastecimentoViewHolder extends RecyclerView.ViewHolder {
    //esta classe representa cada gaveta que será apresentada na lista
    private TextView kmAtual;
    private TextView litrosAbastecido;
    private TextView dataAbastecimento;

    public abastecimentoViewHolder(View itemView) {

        super(itemView);
        kmAtual = itemView.findViewById(R.id.kmAtual);
        litrosAbastecido = itemView.findViewById(R.id.litrosAbastecimento);
        dataAbastecimento = itemView.findViewById(R.id.dataAbastecimento);

    }
    public void atualizaGaveta(Posto objetoPosto){
        this.kmAtual.setText("" + objetoPosto.getKmAtual() );
        this.litrosAbastecido.setText("" + objetoPosto.getLitrosAbastecidos() );
        this.dataAbastecimento.setText( objetoPosto.getData() );

    }
}
