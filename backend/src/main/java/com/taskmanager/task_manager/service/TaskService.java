package com.taskmanager.task_manager.service;

import com.taskmanager.task_manager.entity.Task;
import com.taskmanager.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
