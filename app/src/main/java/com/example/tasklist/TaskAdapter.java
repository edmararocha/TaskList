package com.example.tasklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemTask = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);

        return new MyViewHolder(itemTask);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.task.setText(task.getNome());
    }

    @Override
    public int getItemCount() {
        return this.taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView task;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            task = itemView.findViewById(R.id.textTask);
        }
    }
}
