SELECT
    u.id,
    u.cedula,
    u.nombre,
    u.apellido,
    u.id_ciudad,
    c.nombre AS nombre_ciudad,
    u.telefono
FROM usuario AS u
LEFT JOIN ciudad AS c ON u.id_ciudad = c.id
WHERE
    cedula = :cedula;