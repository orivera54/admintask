package com.taskmanager.task_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
