package com.ceiba.envio.modelo.entidad;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.remitente.modelo.entidad.Remitente;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
public class Envio {

	private static final String REMITENTE_OBLIGATORIO = "Se debe ingresar un remitente nose";
	private static final String DESTINARTARIO_OBLIGATORIO = "Se debe ingresar destinatario";

	private static final String PESO_OBLIGATORIO = "Se debe ingresar un peso";
	private static final String PESO_MENOR_50 = "Se debe ingresar un peso menor a 50 kg";
	private static final String PESO_MAYOR_0 = "Se debe ingresar un peso positivo";

	private static final String COSTO_OBLIGATORIO = "se debe de ingresar un costo";
	private static final String FECHA_LLEGADA_OBLIGATORIA = "se debe ingresar una fecha estimada de llegada";

	private static final Long PESO_MAXIMO = 50L;

	private Long id;
	private Remitente remitente;
	private Destinatario destinatario;
	private double peso;

	private BigDecimal costo;
	private LocalDate fechaEstimadaLlegada;

	public Envio(Remitente remitente, Destinatario destinatario, double peso){

		System.out.println(remitente.toString());
		//validarObligatorio(remitente, REMITENTE_OBLIGATORIO);
		validarObligatorio(destinatario, DESTINARTARIO_OBLIGATORIO);
		validarObligatorio(peso, PESO_OBLIGATORIO);
		validarMenor((long) peso, PESO_MAXIMO, PESO_MENOR_50);
		validarPositivo(peso, PESO_MAYOR_0);

		this.remitente = remitente;
		this.destinatario = destinatario;
		this.peso = peso;
	}

	public Envio(Remitente remitente, Destinatario destinatario, double peso, BigDecimal costo, LocalDate fechaEstimadaLlegada) {

		validarObligatorio(remitente, REMITENTE_OBLIGATORIO);
		validarObligatorio(destinatario, DESTINARTARIO_OBLIGATORIO);
		validarObligatorio(peso, PESO_OBLIGATORIO);
		validarMenor((long) peso, PESO_MAXIMO, PESO_MENOR_50);
		validarPositivo(peso, PESO_MAYOR_0);

		validarObligatorio(costo, COSTO_OBLIGATORIO);
		validarObligatorio(fechaEstimadaLlegada, FECHA_LLEGADA_OBLIGATORIA);

		this.remitente = remitente;
		this.destinatario = destinatario;
		this.peso = peso;
		this.costo = costo;
		this.fechaEstimadaLlegada = fechaEstimadaLlegada;
	}


	/*public Envio(String nombre, String apellido, String telefono, int ciudadOrigen, int ciudadDestino,
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
	}*/



}
