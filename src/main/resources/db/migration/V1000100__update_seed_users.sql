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
VALUES ('20-45123456-0', 'perez', 'juan', 2);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);