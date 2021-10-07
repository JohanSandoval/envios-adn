SELECT COUNT(1) FROM costo_envio
WHERE peso_minimo = :pesoMin AND peso_maximo = :pesoMax;