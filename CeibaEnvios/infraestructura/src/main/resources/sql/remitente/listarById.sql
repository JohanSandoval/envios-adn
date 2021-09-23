SELECT
    id,
    cedula,
    nombre,
    apellido,
    ciudad,
    telefono
FROM remitente
WHERE id = :id;