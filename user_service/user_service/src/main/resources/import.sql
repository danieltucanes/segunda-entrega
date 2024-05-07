INSERT INTO rol (role_Id, role_Name) VALUES (1, 'Super_Administrador');
INSERT INTO rol (role_Id, role_Name) VALUES (2, 'Administrador');
INSERT INTO rol (role_Id, role_Name) VALUES (3, 'Editor');
INSERT INTO rol (role_Id, role_Name) VALUES (4, 'Visitante_Registrado');

INSERT INTO usuario (user_id, user_name, user_email, user_password) VALUES (1, 'Usuario1', 'usu1hotmail', 'pasusu1');
INSERT INTO usuario_user_roles (user_roles_role_id, user_user_id) VALUES (2, 1);
INSERT INTO usuario_user_roles (user_roles_role_id, user_user_id) VALUES (5, 1);

INSERT INTO usuario (user_id, user_name, user_email, user_password) VALUES (2, 'Usuario2', 'usu2hotmail', 'pasusu2');
INSERT INTO usuario_user_roles (user_roles_role_id, user_user_id) VALUES (1, 2);
INSERT INTO usuario_user_roles (user_roles_role_id, user_user_id) VALUES (3, 2);

INSERT INTO usuario (user_id, user_name, user_email, user_password) VALUES (3, 'Usuario2', 'usu2hotmail', 'pasusu2');
INSERT INTO usuario_user_roles (user_roles_role_id, user_user_id) VALUES (4, 3);