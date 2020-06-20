package com.example.a5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
/*
* Criado por: Andressa Torres, Douglas Ghiraldello Rodrigues, Emmanuel Bitello.
* */
public class MainActivity extends AppCompatActivity {

    private ImageView imLogin;
    private ImageView imJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imJogos  = (ImageView)  findViewById(R.id.iconjogos);
        imLogin  = (ImageView)  findViewById(R.id.iconLogin);

        imLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        imJogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaJogos.class);
                startActivity(intent);
            }
        });

    }
}