package com.example.tasklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddTask extends AppCompatActivity {

    private TextInputEditText textTask;
    private Task atualTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        textTask = findViewById(R.id.textTask);

        // recuperar tarefa caso seja uma edição
        atualTask = (Task) getIntent().getSerializableExtra("task selected");

        // configurar tarefa na caixa de texto
        if (atualTask != null) {
            textTask.setText(atualTask.getNome());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSave:

                TaskDAO taskDAO = new TaskDAO(getApplicationContext());

                // editar
                if (atualTask != null) {
                    String taskName = textTask.getText().toString();

                    if (!taskName.isEmpty()) {
                        Task task = new Task();
                        task.setNome(taskName);
                        task.setId(atualTask.getId());

                        if (taskDAO.update(task)) {
                            Toast.makeText(getApplicationContext(), "Sucesso ao atualizar tarefa!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    finish();

                // salvar
                } else {

                    String taskName = textTask.getText().toString();

                    if (!taskName.isEmpty()) {
                        Task task = new Task();
                        task.setNome(taskName);

                        if (taskDAO.save(task)) {
                            Toast.makeText(getApplicationContext(), "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    finish();
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}