package com.ceiba.envio.modelo.dto;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.remitente.modelo.dto.DtoRemitente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEnvio {

	private Long id;
	private DtoRemitente remitente;
	private DtoDestinatario destinatario;
	private double peso;

	private BigDecimal costo;
	private LocalDate fechaEstimadaLlegada;

}
