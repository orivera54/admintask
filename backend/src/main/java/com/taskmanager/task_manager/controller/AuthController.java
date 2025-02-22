package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.service.JwtService;
import com.taskmanager.task_manager.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        UserDetails userDetails = userService.findByEmail(email);
        return jwtService.generateToken(userDetails);
    }
}
