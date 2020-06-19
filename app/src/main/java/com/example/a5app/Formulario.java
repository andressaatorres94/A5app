package com.example.a5app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {
    private EditText edtNome, edtDesenvolvedora, edtPublicadora, edtPlataforma;
    private EditText edtSerie, edtGenero, edtLancamento;
    private Button btnSalvar, btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        edtNome = (EditText) findViewById(R.id.etNome);
        edtDesenvolvedora = (EditText) findViewById(R.id.etDesenvolvedor);
        edtPublicadora = (EditText) findViewById(R.id.etPublicadora);
        edtPlataforma = (EditText) findViewById(R.id.etPlataforma);
        edtSerie = (EditText) findViewById(R.id.etSerie);
        edtGenero = (EditText) findViewById(R.id.etGenero);
        edtLancamento = (EditText) findViewById(R.id.etLancamento);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

    }
}
