SELECT
	de.id,
    de.dias,
    de.id_ciudad_origen,
    co.nombre AS nombre_ciudad_origen,
    de.id_ciudad_destino,
    cd.nombre AS nombre_ciudad_destino
FROM dias_espera AS de
LEFT JOIN ciudad AS co ON de.id_ciudad_origen = co.id
LEFT JOIN ciudad AS cd ON de.id_ciudad_destino = cd.id
WHERE id_ciudad_destino = :idCiudadD AND id_ciudad_origen = :idCiudadO