INSERT INTO user (id, username, password)
VALUES (1, 'client', '1234');
INSERT INTO user (id, username, password)
VALUES (2, 'professional', '4567');

INSERT INTO role (id, name)
VALUES (1, 'client');
INSERT INTO role (id, name)
VALUES (2, 'professional');

INSERT INTO client (dni, last_name, name, id)
VALUES ('50123456', 'perez', 'juan', 1);

INSERT INTO professional (cuil, last_name, name, id)
VALUES ('20-45123456-0', 'fuentes', 'roberto', 2);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);

INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (1, '2025-05-27', 0, '10:00:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (2, '2025-05-27', 0, '10:30:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (3, '2025-05-27', 0, '11:00:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (4, '2025-05-27', 0, '11:30:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (5, '2025-05-27', 0, '12:00:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id, client_id)
VALUES (6, '2025-05-27', 1, '12:30:00', 2, 1);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (7, '2025-05-27', 0, '13:00:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (8, '2025-05-27', 0, '13:30:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id)
VALUES (9, '2025-05-27', 0, '14:00:00', 2);
INSERT INTO appointment (id, date, is_blocked, time, professional_id, client_id)
VALUES (10, '2025-05-27', 1, '14:30:00', 2, 1);