UPDATE envio
set id_remitente = :idRemitente,
    id_destinatario = :idDestinatario,
    peso = :peso,
    costo = :costo,
    fecha_llegada = :fechaLlegada
WHERE id = :id;