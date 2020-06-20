package com.example.a5app;

import androidx.annotation.NonNull;

public class Jogos {
    public String id, nomeJogo, desenvolvedora, publicadora;
    public String serie, genero , plataforma;
    public String lancamento;

    @NonNull
    @Override
    public String toString() {
        return "Nome do jogo: " + nomeJogo + "\nAno de lançamento: "+ lancamento + "\nPlataforma: " +
                plataforma + "\nPublicadora(s): " + publicadora + "\nDesenvolvedora(s): " + desenvolvedora +
                "\nGênero: " + genero;
    }
}
