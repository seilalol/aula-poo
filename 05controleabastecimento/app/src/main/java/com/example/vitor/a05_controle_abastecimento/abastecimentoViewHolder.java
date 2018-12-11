package com.example.vitor.a05_controle_abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class abastecimentoViewHolder extends RecyclerView.ViewHolder {
    //esta classe representa cada gaveta que será apresentada na lista
    private TextView kmAtual;
    private TextView litrosAbastecido;
    private TextView dataAbastecimento;
    private ImageView posto;
    private TextView postoView;

    public abastecimentoViewHolder(View itemView) {

        super(itemView);
        this.kmAtual = itemView.findViewById(R.id.kmAtual);
        this.litrosAbastecido = itemView.findViewById(R.id.litrosAbastecimento);
        this.dataAbastecimento = itemView.findViewById(R.id.dataAbastecimento);
        this.posto = (ImageView) itemView.findViewById(R.id.postoImg);
        this.postoView = itemView.findViewById(R.id.postoT);

    }
    public void atualizaGaveta(Posto objetoPosto){ //Apenas atualiza a gaveta
        this.kmAtual.setText("" + objetoPosto.getKmAtual() );
        this.litrosAbastecido.setText("" + objetoPosto.getLitrosAbastecidos() + " Litros" );
        this.dataAbastecimento.setText( objetoPosto.getData() );
        this.postoView.setText(objetoPosto.getPosto());

        if("Ipiranga".equals(objetoPosto.getPosto())) {
            this.posto.setImageResource(R.drawable.ipiranga);
        }if("Shell".equals(objetoPosto.getPosto())) {
            this.posto.setImageResource(R.drawable.shell);
        }if("Petrobas".equals(objetoPosto.getPosto())){
            this.posto.setImageResource(R.drawable.petrobas);
        }if("Texaco".equals(objetoPosto.getPosto())){
            this.posto.setImageResource(R.drawable.texaco);
        }
    }
}
