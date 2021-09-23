SELECT
    d.id,
    d.cedula,
    d.nombre,
    d.apellido,
    d.ciudad,
    d.direccion
FROM destinatario AS d
WHERE d.cedula = :cedula;