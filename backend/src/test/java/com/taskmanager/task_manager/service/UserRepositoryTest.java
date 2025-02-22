package com.taskmanager.task_manager.service;

import com.taskmanager.task_manager.entity.User;
import com.taskmanager.task_manager.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

public class UserRepositoryTest {

    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        entityManager.persist(user);

        Optional<User> found = userRepository.findByEmail("test@example.com");

        assertTrue(found.isPresent());
        assertEquals("test@example.com", found.get().getEmail());
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("test@example.com", savedUser.getEmail());
    }
    
}
