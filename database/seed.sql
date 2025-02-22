-- Insertar roles
INSERT INTO roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- Insertar permisos
INSERT INTO permissions (name) VALUES
('CREATE_TASK'),
('READ_TASK'),
('UPDATE_TASK'),
('DELETE_TASK'),
('ASSIGN_TASK');

-- Asignar permisos a roles
INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), -- ROLE_ADMIN tiene todos los permisos
(2, 2); -- ROLE_USER solo puede leer tareas

-- Insertar usuarios
INSERT INTO users (name, email, password, role_id) VALUES
('Admin', 'admin@example.com', 'password', 1),
('User', 'user@example.com', 'password', 2);

-- Insertar tareas
INSERT INTO tasks (title, description, status, user_id) VALUES
('Task 1', 'Description for Task 1', 'Pendiente', 1),
('Task 2', 'Description for Task 2', 'En Progreso', 2);