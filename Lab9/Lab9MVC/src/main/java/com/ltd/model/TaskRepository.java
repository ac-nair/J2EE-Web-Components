package com.ltd.model;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static List<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;

    // Method to add a task
    public void addTask(String description, String status) {
        tasks.add(new Task(idCounter++, description, status));
    }

    // Method to retrieve all tasks
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Method to delete a task by ID
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
