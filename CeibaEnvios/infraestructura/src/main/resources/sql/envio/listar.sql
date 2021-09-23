SELECT
 e.id,
 e.id_remitente,
 e.id_destinatario,
 e.peso,
 e.costo,
 e.fecha_llegada,


 r.cedula AS cedula_remitente,
 r.nombre AS nombre_remitente,
 r.apellido AS apellido_remitente,
 r.ciudad AS ciudad_remitente,
 r.telefono AS telefono_remitente,


 d.cedula AS cedula_destinatario,
 d.nombre AS nombre_destinatario,
 d.apellido AS apellido_destinatario,
 d.ciudad AS ciudad_destinatario,
 d.direccion AS direccion_destinatario
 from envio AS e
 LEFT JOIN remitente AS r ON e.id_remitente = r.id
 LEFT JOIN destinatario AS d ON e.id_destinatario = d.id
