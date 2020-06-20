package com.example.a5app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText edtSenha,edtUsuario;
    private Button btnEntrar, btnCadastro;
    private FirebaseAuth auth;
    private FirebaseUser usuario;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        edtUsuario = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                usuario = auth.getCurrentUser();
                if (usuario != null) {
                    Intent intent = new Intent(Login.this, ListaJogos.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "E-mail ou senha incorreto", Toast.LENGTH_LONG).show();
                }
            }
        };

        //Login
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
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

    private void logar() {
        String email = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if (!email.isEmpty() && !senha.isEmpty()) {
            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                        alerta.setTitle("Atenção!");
                        alerta.setIcon(android.R.drawable.ic_dialog_alert);
                        alerta.setMessage("E-mail e/ou Senha incorreta.");
                        alerta.setPositiveButton("OK", null);
                        alerta.show();

                    } else {
                        Intent intent = new Intent(Login.this, HomeJogos.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

   /* private void cadastrar(){
        String email = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        if( !email.isEmpty() && !senha.isEmpty() ){
            auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            usuario = auth.getCurrentUser();
                        }
                    });
        }

    }*/
}
