package com.taskmanager.task_manager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
    }

    @Test
    void testGenerateToken() {
        UserDetails userDetails = new User("test@example.com", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);

        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    void testExtractUsername() {
        UserDetails userDetails = new User("test@example.com", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);

        String username = jwtService.extractUsername(token);
        assertEquals("test@example.com", username);
    }

    @Test
    void testValidateToken() {
        UserDetails userDetails = new User("test@example.com", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);

        assertTrue(jwtService.isTokenValid(token, userDetails));
    }
}
