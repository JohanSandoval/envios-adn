insert into usuario (
    cedula,
    nombre,
    apellido,
    id_ciudad,
    telefono)
values
    (:cedula, :nombre, :apellido, :ciudad, :telefono);