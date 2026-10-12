package com.example.springbootkursapp.service;

import com.example.springbootkursapp.model.Task;
import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//skoro mamy juz model, baze danych (model) i akcje w repozytorium to pora na wykonawce działan
//czyli serwis, a zeby przeszedl do cyklu zycia lifecycle to oznaczam jako @Service
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksForUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task addTask(Task task, User user) {
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void deleteTask(int taskId, User user) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("No task found "));
        if(!task.getUser().getUsername().equals(user.getUsername())) {
            throw new IllegalArgumentException("You can only delete your own tasks");
        }
    }
}
