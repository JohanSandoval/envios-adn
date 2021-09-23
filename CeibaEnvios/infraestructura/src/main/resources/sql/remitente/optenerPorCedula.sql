SELECT
    r.id,
    r.cedula,
    r.nombre,
    r.apellido,
    r.ciudad,
    r.telefono
FROM remitente AS r
WHERE r.cedula = :cedula;