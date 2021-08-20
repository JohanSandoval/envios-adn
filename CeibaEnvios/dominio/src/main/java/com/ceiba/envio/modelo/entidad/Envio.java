package com.ceiba.envio.modelo.entidad;

import lombok.Data;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Envio {

	private static final String SE_DEBE_INGRESAR_UN_NOMBRE_DESTINATARIO = "Se debe ingresar un nombre de destinatario";
	private static final String SE_DEBE_INGRESAR_UN_APELLIDO_DESTINATARIO = "Se debe ingresar un apellido de destinatario";
	private static final String SE_DEBE_INGRESAR_UN_TELEFONO_CONTACTO = "Se debe ingresar un numero de contacto";

	private static final String SE_DEBE_INGRESAR_UNA_CIUDAD_DE_ORIGEN = "Se debe asignar una ciudad de origen";
	private static final String SE_DEBE_INGRESAR_UNA_CIUDAD_DE_DESTINO = "Se debe asignar una ciudad de destino";

	private static final String SE_DEBE_INGRESAR_UN_PESO_MENOR_50 = "Se debe ingresar un peso menor a 50 kg";
	private static final String SE_DEBE_INGRESAR_UN_PESO_POSITIVO = "Se debe ingresar un peso positivo";

	private static final Long PESO_DEBE_SER_MENOR_A_50 = 50L;

	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;

	private int ciudadOrigen;
	private int ciudadDestino;
	private double peso;

	private double costo;
	private String fechaEstimada;

	public Envio(String nombre, String apellido, String telefono, int ciudadOrigen, int ciudadDestino,
			double peso) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_UN_NOMBRE_DESTINATARIO);
		validarObligatorio(apellido, SE_DEBE_INGRESAR_UN_APELLIDO_DESTINATARIO);
		validarObligatorio(telefono, SE_DEBE_INGRESAR_UN_TELEFONO_CONTACTO);
		validarObligatorio(ciudadOrigen, SE_DEBE_INGRESAR_UNA_CIUDAD_DE_ORIGEN);
		validarObligatorio(ciudadDestino, SE_DEBE_INGRESAR_UNA_CIUDAD_DE_DESTINO);
		validarMenor((long) peso, PESO_DEBE_SER_MENOR_A_50, SE_DEBE_INGRESAR_UN_PESO_MENOR_50);
		validarPositivo(peso, SE_DEBE_INGRESAR_UN_PESO_POSITIVO);

		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.peso = peso;
	}

	public Envio(String nombre, String apellido, String telefono, int ciudadOrigen, int ciudadDestino,
			double peso, double costo, String fechaEstimada) {
		super();
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
