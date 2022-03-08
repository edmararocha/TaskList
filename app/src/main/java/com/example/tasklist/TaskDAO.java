package com.example.tasklist;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements ITaskDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public TaskDAO(Context context) {
        DbHelper db = new DbHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean save(Task task) {

        ContentValues cv = new ContentValues();
        cv.put("name", task.getNome());

        try {
            write.insert(DbHelper.TASKS_TABLE, null, cv);
            Log.i("INFO", "[+] Tarefa salva com sucesso!");
        } catch (Exception e) {
            Log.e("INFO", "[-] Erro ao salvar tarefa - " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Task task) {
        return false;
    }

    @Override
    public boolean delete(Task task) {
        return false;
    }

    @Override
    public List<Task> list() {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TASKS_TABLE + " ;";

        Cursor cursor = read.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Task task = new Task();

            @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));

            @SuppressLint("Range") String taskName = cursor.getString(cursor.getColumnIndex("name"));

            task.setId(id);
            task.setNome(taskName);

            tasks.add(task);
        }

        return tasks;
    }
}
