SELECT id, peso_maximo, peso_minimo, costo FROM costo_envio
WHERE peso_maximo >= :peso and peso_minimo< :peso;