package com.example.a5app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListaJogos extends AppCompatActivity {

    public String id, nome, desenvolvedor, publicadora, plataforma, serie, genero, lancamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);
    }
}
