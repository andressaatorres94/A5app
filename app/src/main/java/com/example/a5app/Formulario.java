package com.example.a5app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mudar para class lista qnd for criardo (APAGAR ESSE COMENTARIO )
                Intent intent = new Intent(Formulario.this, Login.class);
                startActivity(intent);
            }
        });

    }

    public void salvar(){
        String nome = edtNome.getText().toString();
        String desenvolvedora = edtDesenvolvedora.getText().toString();
        String publicadora = edtPublicadora.getText().toString();
        String plataforma = edtPlataforma.getText().toString();
        String serie = edtSerie.getText().toString();
        String genero = edtGenero.getText().toString();
        String lancamento = edtLancamento.getText().toString();

        if(!nome.isEmpty() && !desenvolvedora.isEmpty() && !publicadora.isEmpty() && !plataforma.isEmpty()&& !serie.isEmpty()&& !genero.isEmpty()
                && !lancamento.isEmpty()) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Atenção!");
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setMessage("Jogo cadastrado com sucesso.");
            alerta.setNeutralButton("OK",null);
            alerta.show();
            finish();
        } else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Atenção!");
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setMessage("Preencha todos os campos corretamente.");
            alerta.setNeutralButton("OK",null);
            alerta.show();
        }


    }
}
