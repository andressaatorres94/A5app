package com.example.a5app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Formulario extends AppCompatActivity {
    private EditText edtNome, edtDesenvolvedora, edtPublicadora, edtPlataforma;
    private EditText edtSerie, edtGenero, edtLancamento;
    private Button btnSalvar, btnVoltar;

    private FirebaseDatabase database;
    private DatabaseReference reference;

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

        //salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        //voltar
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Formulario.this, Login.class);
                startActivity(intent);
                finish();
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

            Jogos jogos = new Jogos();

            jogos.nomeJogo = nome;
            jogos.desenvolvedora = desenvolvedora;
            jogos.publicadora = publicadora;
            jogos.plataforma = plataforma;
            jogos.serie = serie;
            jogos.genero = genero;
            jogos.lancamento = lancamento;

            database = FirebaseDatabase.getInstance();
            reference = database.getReference();
            reference.child("jogos").push().setValue(jogos);

            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setIcon(android.R.drawable.ic_dialog_info);
            alerta.setMessage("Jogo cadastrado com sucesso.");
            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    edtNome.setText("");
                    edtDesenvolvedora.setText("");
                    edtPlataforma.setText("");
                    edtPublicadora.setText("");
                    edtGenero.setText("");
                    edtLancamento.setText("");
                    edtSerie.setText("");
                }
            });

            alerta.show();

        } else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Atenção!");
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setMessage("Preencha todos os campos corretamente.");
            alerta.setPositiveButton("OK",null);
            alerta.show();
        }


    }
}
