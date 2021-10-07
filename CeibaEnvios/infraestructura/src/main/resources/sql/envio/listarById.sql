SELECT
 e.id,
 e.id_usuario_remitente,
 e.id_usuario_destinatario,
 e.peso,
 e.costo,
 e.fecha_llegada,
 e.direccion,

 r.cedula AS cedula_remitente,
 r.nombre AS nombre_remitente,
 r.apellido AS apellido_remitente,
 r.id_ciudad AS id_ciudad_remitente,
 r.telefono AS telefono_remitente,

 cr.nombre AS nombre_ciudad_remitente,

 d.cedula AS cedula_destinatario,
 d.nombre AS nombre_destinatario,
 d.apellido AS apellido_destinatario,
 d.id_ciudad AS id_ciudad_destinatario,
 d.telefono AS telefono_destinatario,

 cr.nombre AS nombre_ciudad_destinatario

 FROM envio AS e
 LEFT JOIN usuario AS r ON e.id_usuario_remitente = r.id
 LEFT JOIN usuario AS d ON e.id_usuario_destinatario = d.id
 LEFT JOIN ciudad AS cr ON r.id_ciudad = cr.id
 LEFT JOIN ciudad AS cd ON d.id_ciudad = cd.id
WHERE
    e.id = :id;