INSERT INTO users (user_name, user_last_name, user_email, user_nickname, user_phone, password, user_image, user_type) VALUES ('Juan', 'Perez', 'juan.perez@example.com', 'juanp', '555-1234', 'securePassword123', null, 0);
INSERT INTO users (user_name, user_last_name, user_email, user_nickname, user_phone, password, user_image, user_type) VALUES ('Maria', 'Lopez', 'maria.lopez@example.com', 'marial', '555-5678', 'anotherSecurePassword456', null, 1);
INSERT INTO users (user_name, user_last_name, user_email, user_nickname, user_phone, password, user_image, user_type) VALUES ('Carlos', 'Martinez', 'carlos.martinez@example.com', 'carlosm', '555-6789', 'securePassword789', null, 0);
INSERT INTO users (user_name, user_last_name, user_email, user_nickname, user_phone, password, user_image, user_type) VALUES ('Ana', 'Gomez', 'ana.gomez@example.com', 'anag', '555-7890', 'securePassword012', null, 1);
INSERT INTO users (user_name, user_last_name, user_email, user_nickname, user_phone, password, user_image, user_type) VALUES ('Luis', 'Fernandez', 'luis.fernandez@example.com', 'luisf', '555-8901', 'securePassword345', null, 0);

INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cuál es tu color favorito?', 'Azul', 1);
INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cuál es el nombre de tu escuela primaria?', 'Escuela Primaria ABC', 2);
INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cómo se llama tu primera mascota?', 'Fido', 2);
INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cuál es tu película favorita?', 'Inception', 3);
INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cuál es tu deporte favorito?', 'Fútbol', 4);
INSERT INTO securityquestions (question, answer, user_id) VALUES ('¿Cuál es tu libro favorito?', 'Cien años de soledad', 5);
