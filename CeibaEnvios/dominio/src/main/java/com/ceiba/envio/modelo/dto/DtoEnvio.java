package com.ceiba.envio.modelo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DtoEnvio {

	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;

	private int ciudadOrigen;
	private int ciudadDestino;
	private double peso;

	private double costo;
	private String fechaEstimada;
	
	public DtoEnvio(Long id, String nombre, String apellido, String telefono, int ciudadOrigen, int ciudadDestino,
			double peso, double costo, String fechaEstimada) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.peso = peso;
		this.costo = costo;
		this.fechaEstimada = fechaEstimada;
	}



}
