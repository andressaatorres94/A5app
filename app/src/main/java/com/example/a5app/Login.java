package com.example.a5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText edtSenha,edtUsuario;
    private Button btnEntrar, btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        edtUsuario = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Login.this, Formulario.class);
            startActivity(intent);
            finish();
            }
        });

        //novo usuario

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, NovoUsuario.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
