SELECT
	de.id,
    de.dias,
    de.id_ciudad_origen,
    co.nombre AS nombreCiudadO,
    de.id_ciudad_destino,
    cd.nombre AS nombreCiudadD
FROM dias_espera AS de
LEFT JOIN ciudad AS co ON de.id_ciudad_origen = co.id
LEFT JOIN ciudad AS cd ON de.id_ciudad_destino = cd.id
WHERE de.id = :id;