SELECT
    id,
    cedula,
    nombre,
    apellido,
    ciudad,
    direccion
FROM destinatario
WHERE id = :id;