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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        textTask = findViewById(R.id.textTask);
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
                Task task = new Task();
                task.setNome("tarefa");
                taskDAO.save(task);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}