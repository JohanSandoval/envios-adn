UPDATE destinatario
set cedula = :cedula,
    nombre = :nombre,
    apellido = :apellido,
    ciudad = :ciudad,
    direccion = :direccion
WHERE id = :id;