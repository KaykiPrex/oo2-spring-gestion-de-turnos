-- USERS
INSERT INTO user (id, username, password)
VALUES (1, 'client', '1234'),
       (2, 'professional', '4567');

INSERT INTO role (id, name)
VALUES (1, 'client'),
       (2, 'professional');

INSERT INTO client (dni, last_name, name, id)
VALUES ('50123456', 'perez', 'juan', 1);

INSERT INTO professional (cuil, last_name, name, id)
VALUES ('20-45123456-0', 'fuentes', 'roberto', 2);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2);

-- CATEGORY
INSERT INTO category (id, name)
VALUES (1, 'medicina'),
       (2, 'justicia');

-- SPECIALTY
INSERT INTO specialty (id, description, name, category_id)
VALUES (1, null, 'clinica general', 1),
       (2, null, 'traumatologia', 1);

INSERT INTO professional_specialty (id, status, professional_id, specialty_id)
VALUES (1, 'active', 2, 1);

-- SERVICE
INSERT INTO service (id, description, name, specialty_id)
VALUES (1, 'servicio de atencion general', 'consulta general', 1);

INSERT INTO professional_service (id, price, professional_id, service_id)
VALUES (1, 0, 2, 1);

-- APPOINTMENT DATE
INSERT INTO appointment_date (id, date)
VALUES (1, '2025-09-22'),
       (2, '2025-09-23'),
       (3, '2025-09-24'),
       (4, '2025-09-25'),
       (5, '2025-09-26'),
       (6, '2025-09-29'),
       (7, '2025-09-30'),
       (8, '2025-10-01'),
       (9, '2025-10-02'),
       (10, '2025-10-03'),
       (11, '2025-10-06'),
       (12, '2025-10-07'),
       (13, '2025-10-08'),
       (14, '2025-10-09'),
       (15, '2025-10-10'),
       (16, '2025-10-13'),
       (17, '2025-10-14'),
       (18, '2025-10-15'),
       (19, '2025-10-16'),
       (20, '2025-10-17'),
       (21, '2025-10-20'),
       (22, '2025-10-21'),
       (23, '2025-10-22');

-- APPOINTMENT
-- Free
INSERT INTO appointment (id, is_blocked, time, professional_id, professional_service_id, appointment_date)
VALUES (1, 0, '10:00:00', 2, 1, 1),
       (2, 0, '10:30:00', 2, 1, 1),
       (3, 0, '11:00:00', 2, 1, 1),
       (4, 0, '11:30:00', 2, 1, 1),
       (5, 0, '12:00:00', 2, 1, 1),
       (6, 0, '12:30:00', 2, 1, 1),
       (7, 0, '13:00:00', 2, 1, 1);
-- Blocked
INSERT INTO appointment (id, is_blocked, time, professional_id, client_id, professional_service_id, appointment_date)
VALUES (8, 1, '13:30:00', 2, 1, 1, 1),
       (9, 1, '14:00:00', 2, 1, 1, 1),
       (10, 1, '14:30:00', 2, 1, 1, 1);
