package com.ceiba.envio.comando;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ComandoEnvio {

	private String cedulaRemitente;
	private String cedulaDestinatario;
	private double peso;
}
