package com.example.vitor.a05_controle_abastecimento;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class abastecimentoAdapter extends RecyclerView.Adapter {
    public ArrayList<Posto> listaAvaliacoes;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflando o XML
        View elementoPaiDoXML =
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(
                        R.layout.activity_posto_item_lista,
                        parent,
                        false
                );
        abastecimentoViewHolder minhaGaveta = new abastecimentoViewHolder(elementoPaiDoXML);
        return minhaGaveta;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //método que deve vestir a gaveta
        abastecimentoViewHolder minhaGaveta = (abastecimentoViewHolder) holder;
        Posto daVez = listaAvaliacoes.get(position);
        minhaGaveta.atualizaGaveta( daVez );

    }
    @Override
    public int getItemCount() {
        //retornar o total de itens da lista
        return listaAvaliacoes.size();
    }
}



