package com.example.a5app.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {
    private static String nome = "com.example.a5app.banco.BancoDados.db";
    private static int versao = 1;


    public BancoDados(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [Usuario] (\n" +
                    "[codigo] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "[nomeUsuario] vaRCHAR(50)  NOT NULL,\n" +
                    "[emailUsuario] vaRCHAR(50)  NOT NULL,\n" +
                    "[senhaUsuario] vaRCHAR(50)  NOT NULL,\n" +
                    "[confirmarSenha] VARCHAR(50)  NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
