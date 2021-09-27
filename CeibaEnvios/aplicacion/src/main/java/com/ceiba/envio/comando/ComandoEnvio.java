package com.ceiba.envio.comando;

import lombok.*;

@Data
public class ComandoEnvio {

	private Long id;
	private String cedulaRemitente;
	private String cedulaDestinatario;
	private double peso;
}
