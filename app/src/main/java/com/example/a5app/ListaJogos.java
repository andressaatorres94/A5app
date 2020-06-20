package com.example.a5app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class ListaJogos extends AppCompatActivity {
    private ImageButton ibVoltar;
    private ListView lvJogos;
    private List<Jogos> listaJogos;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ChildEventListener childEventListener;
    private Query query;
    private ArrayAdapter<Jogos> adapter;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltarInicio);
        lvJogos = (ListView) findViewById(R.id.lvJogos);

        listaJogos = new ArrayList<>();
        adapter = new ArrayAdapter<Jogos>(ListaJogos.this, android.R.layout.simple_list_item_1, listaJogos);
        lvJogos.setAdapter(adapter);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaJogos.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        listaJogos.clear();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        query = reference.child("jogos").orderByChild("nomeJogo");
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                Jogos jg = new Jogos();

                jg.id = dataSnapshot.getKey();
                jg.nomeJogo = dataSnapshot.child("nomeJogo").getValue(String.class);
                jg.desenvolvedora = dataSnapshot.child("desenvolvedora").getValue(String.class);
                jg.publicadora = dataSnapshot.child("publicadora").getValue(String.class);
                jg.serie = dataSnapshot.child("serie").getValue(String.class);
                jg.genero = dataSnapshot.child("genero").getValue(String.class);
                jg.plataforma = dataSnapshot.child("plataforma").getValue(String.class);
                jg.lancamento = dataSnapshot.child("lancamento").getValue(String.class);

                listaJogos.add(jg);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        query.addChildEventListener(childEventListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        query.removeEventListener(childEventListener);
    }
}
