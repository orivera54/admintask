package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.entity.Task;
import com.taskmanager.task_manager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> findByUserId(@PathVariable Long userId) {
        return taskService.findByUserId(userId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }
}