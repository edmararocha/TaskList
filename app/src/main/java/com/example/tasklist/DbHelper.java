package com.example.tasklist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME_DB = "DB_TASKS";
    public static String TASKS_TABLE = "tasks";

    public DbHelper(Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // quando o usuário instala o app

        String sql = "CREATE TABLE IF NOT EXISTS " + TASKS_TABLE
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL); ";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "[+] Sucesso ao criar a tabela");
        } catch (Exception e) {
            Log.i("INFO DB", "[-] Erro ao criar o banco de dados " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // atualização do app
    }
}
