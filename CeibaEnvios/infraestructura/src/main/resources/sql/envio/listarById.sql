select id, nombre, apellido, telefono, ciudad_origen_id, ciudad_destino_id,
peso, costo, fecha_llegada from envio where id = :id;