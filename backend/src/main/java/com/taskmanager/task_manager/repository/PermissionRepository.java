package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
