INSERT INTO ciudad (nombre) values('BOGOTA');
INSERT INTO ciudad (nombre) values('CALI');

INSERT INTO dias_espera (id_ciudad_origen, id_ciudad_destino, dias)
     VALUES (1,1,1);

INSERT INTO usuario (cedula, nombre, apellido, id_ciudad, telefono)
    VALUES ('12345678', 'Karla', 'Lopez', 1, '5555555');

INSERT INTO costo_envio (peso_maximo, peso_minimo, costo)
    VALUES (10, 0.1, 5000);

INSERT INTO envio (id_usuario_remitente, id_usuario_destinatario, peso, costo, fecha_llegada, direccion)
    VALUES (1, 1, 6, 30000, NOW(), 'CALLE 75 A SUR');