UPDATE costo_envio
SET peso_minimo = :pesoMin,
    peso_maximo = :pesoMax,
    costo = :costo
WHERE id = :id;