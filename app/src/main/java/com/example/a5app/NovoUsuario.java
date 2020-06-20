package com.example.a5app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NovoUsuario extends AppCompatActivity {
    private EditText edtNome, edtEmail, edtSenha, edtConfirmar;
    private Button btnSalvar;
    private ImageButton imVoltar;
    private FirebaseAuth auth;
    private FirebaseUser usuario;
    private FirebaseAuth.AuthStateListener authStateListener;

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

        auth = FirebaseAuth.getInstance();

        //botao salvar
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
                finish();
            }
        });

    }
   public void salvar(){
       String nome = edtNome.getText().toString();
       String email = edtEmail.getText().toString();
       String senha = edtSenha.getText().toString();
       String confirmarSenha = edtConfirmar.getText().toString();

       auth = FirebaseAuth.getInstance();

       if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmarSenha.isEmpty()){
         if(confirmarSenha .equals(senha)){
               auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(NovoUsuario.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           usuario = auth.getCurrentUser();

                           AlertDialog.Builder alerta = new AlertDialog.Builder(NovoUsuario.this);
                           alerta.setIcon(android.R.drawable.ic_dialog_info);
                           alerta.setMessage("Novo usuário cadastrado.");
                           alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   edtEmail.setText("");
                                   edtNome.setText("");
                                   edtSenha.setText("");
                                   edtConfirmar.setText("");
                                   finish();
                               }
                           });
                           alerta.show();

                       } else {
                           Toast.makeText(NovoUsuario.this,"Erro ao cadastrar usuário.", Toast.LENGTH_LONG).show();
                       }
                   }
               });
           } else {
               Toast.makeText(NovoUsuario.this,"As senhas não correspondem", Toast.LENGTH_LONG).show();
           }
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
