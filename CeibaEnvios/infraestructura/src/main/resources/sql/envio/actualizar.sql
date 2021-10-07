UPDATE envio
set id_usuario_remitente = :idRemitente,
    id_usuario_destinatario = :idDestinatario,
    peso = :peso,
    costo = :costo,
    fecha_llegada = :fechaLlegada,
    direccion = :direccion
WHERE id = :id;