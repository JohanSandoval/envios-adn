package com.ceiba.envio.modelo.dto;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEnvio {

	private Long id;
	private DtoUsuario remitente;
	private DtoUsuario destinatario;
	private double peso;

	private BigDecimal costo;
	private LocalDate fechaEstimadaLlegada;
	private String direccion;

}
