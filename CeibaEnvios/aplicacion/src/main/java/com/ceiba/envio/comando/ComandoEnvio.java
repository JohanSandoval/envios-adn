package com.ceiba.envio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ComandoEnvio {

	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;

	private int ciudadOrigen;
	private int ciudadDestino;
	private double peso;

	public ComandoEnvio(String nombre, String apellido, String telefono, int ciudadOrigen, int ciudadDestino, double peso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.peso = peso;
	}



}
