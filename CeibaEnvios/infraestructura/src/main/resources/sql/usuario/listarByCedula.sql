select
    u.id,
    u.cedula,
    u.nombre,
    u.apellido,
    u.id_ciudad,
    u.telefono,

    c.nombre AS nombre_ciudad
from usuario AS u
LEFT JOIN ciudad AS c ON u.id_ciudad = c.id
WHERE cedula = :cedula