UPDATE dias_espera
SET
    id_ciudad_origen = :idCiudadO,
    id_ciudad_destino = :idCiudadD,
    dias = :dias
WHERE
    id = :id