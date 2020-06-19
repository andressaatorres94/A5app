package com.example.a5app;

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

        //voltar

        imVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NovoUsuario.this, Login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
