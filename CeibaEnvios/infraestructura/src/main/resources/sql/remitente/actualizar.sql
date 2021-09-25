UPDATE remitente
SET nombre = :nombre,
    apellido = :apellido,
    ciudad = :ciudad,
    telefono = :telefono
WHERE id = :id;