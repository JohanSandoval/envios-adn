SELECT COUNT(1) FROM costo_envio WHERE id <> :id
AND peso_minimo = :pesoMin AND peso_maximo = :pesoMax;