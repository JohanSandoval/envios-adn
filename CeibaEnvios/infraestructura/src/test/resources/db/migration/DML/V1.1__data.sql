INSERT INTO remitente (cedula, nombre, apellido, ciudad, telefono)
    VALUES ('12345678', 'R nombre', 'R apellido', 'BOGOTA', '55555');

INSERT INTO destinatario (cedula, nombre, apellido, ciudad, direccion)
    VALUES ('87654321', 'D nombre', 'D apellido', 'CALI', 'D direccion');

INSERT INTO envio (id_remitente, id_destinatario, peso, costo, fecha_llegada)
    VALUES (1, 1, 15, 4750, now());