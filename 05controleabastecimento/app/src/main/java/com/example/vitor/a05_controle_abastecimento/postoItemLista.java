package com.example.vitor.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class postoItemLista extends AppCompatActivity {
    private TextView postoView;
    private ImageView posto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posto_item_lista);
    }

}
