UPDATE remitente
SET cedula = :cedula,
    nombre = :nombre,
    apellido = :apellido,
    ciudad = :ciudad,
    telefono = :telefono
WHERE id = :id;