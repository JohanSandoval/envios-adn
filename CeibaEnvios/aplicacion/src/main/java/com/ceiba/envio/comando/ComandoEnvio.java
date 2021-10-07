package com.ceiba.envio.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEnvio {

	private Long id;
	private String cedulaRemitente;
	private String cedulaDestinatario;
	private double peso;
	private String direccion;
}
