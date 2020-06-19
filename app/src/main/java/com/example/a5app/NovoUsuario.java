package com.example.a5app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class NovoUsuario extends AppCompatActivity {
    private EditText edtNome, edtEmail, edtSenha, edtConfirmar;
    private Button btnSalvar;
    private ImageButton imVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        edtNome = (EditText) findViewById(R.id.edtNomeUsuario);
        edtEmail = (EditText) findViewById(R.id.edtEmailUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenhaUsuario);
        edtConfirmar = (EditText) findViewById(R.id.edtConfirmarSenha);
        btnSalvar = (Button) findViewById(R.id.btnSalvarUsuario);
        imVoltar = (ImageButton) findViewById(R.id.imbVoltar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();

            }
        });
        //voltar
        imVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(NovoUsuario.this, Login.class);
            startActivity(intent);
            }
        });


    }
    public void salvar(){
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        String confirmar = edtConfirmar.getText().toString();

        if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmar.isEmpty()) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setIcon(android.R.drawable.ic_dialog_info);
            alerta.setMessage("Novo usuário cadastrado.");
            alerta.setPositiveButton("OK",null);
            alerta.show();
            finish();

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
