package com.example.tasklist;

import java.util.List;

public interface ITaskDAO {
    public boolean save (Task task);
    public boolean update (Task task);
    public boolean delete (Task task);
    public List<Task> list();
}
