package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.entity.User;
import com.taskmanager.task_manager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
