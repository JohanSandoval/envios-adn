update usuario
set
    cedula = :cedula,
    nombre = :nombre,
    apellido = :apellido,
    id_ciudad = :ciudad,
    telefono = :telefono
where
    id = :id