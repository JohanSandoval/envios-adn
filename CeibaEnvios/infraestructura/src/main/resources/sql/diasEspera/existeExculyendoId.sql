select count(1) from dias_espera where id <> :id
and id_ciudad_origen = :idCiudadO AND id_ciudad_destino = :idCiudadD