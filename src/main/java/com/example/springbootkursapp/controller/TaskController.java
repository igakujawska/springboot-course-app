package com.example.springbootkursapp.controller;

import com.example.springbootkursapp.model.Task;
import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //aby na razie ktokolwiek mogl uzywac naszych endpointow
@RequestMapping("/tasks") //przyporzadkowanie endpointow dl atego konkretnego controllera
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }
//ten KONTROLER zwraca REST API w podtaci JSON

    @GetMapping
    public List<Task> getTasksForUser(@AuthenticationPrincipal User user)
    {
        return taskService.getTasksForUser(user);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task, @AuthenticationPrincipal User user)
    {
        return taskService.addTask(task, user);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable int taskId, @AuthenticationPrincipal User user)
    {
        taskService.deleteTask(taskId, user);
    }
}
