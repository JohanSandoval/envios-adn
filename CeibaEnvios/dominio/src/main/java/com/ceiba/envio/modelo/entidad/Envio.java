package com.ceiba.envio.modelo.entidad;

import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
public class Envio {

	private static final String REMITENTE_OBLIGATORIO = "Se debe ingresar un remitente";
	private static final String DESTINARTARIO_OBLIGATORIO = "Se debe ingresar destinatario";

	private static final String PESO_OBLIGATORIO = "Se debe ingresar un peso";
	private static final String PESO_MENOR_50 = "Se debe ingresar un peso maximo a 50 kg";
	private static final String PESO_MAYOR_0 = "Se debe ingresar un peso positivo";

	private static final String COSTO_OBLIGATORIO = "se debe de ingresar un costo";
	private static final String FECHA_LLEGADA_OBLIGATORIA = "se debe ingresar una fecha estimada de llegada";

	private static final Long PESO_MAXIMO = 50L;

	private Long id;
	private Usuario remitente;
	private Usuario destinatario;
	private double peso;

	private BigDecimal costo;
	private LocalDate fechaEstimadaLlegada;
	private String direccion;



	public Envio(Long id, Usuario remitente, Usuario destinatario, double peso, BigDecimal costo, Double diasEspera, String direccion){

		validarObligatorio(remitente, REMITENTE_OBLIGATORIO);
		validarObligatorio(destinatario, DESTINARTARIO_OBLIGATORIO);
		validarObligatorio(peso, PESO_OBLIGATORIO);
		validarMenor((long) peso, PESO_MAXIMO, PESO_MENOR_50);
		validarPositivo(peso, PESO_MAYOR_0);

		this.id = id;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.peso = peso;
		this.costo = calcularCosto(peso, costo);
		this.fechaEstimadaLlegada = calcularFechaLlegada(diasEspera);
		this.direccion = direccion;

	}

	private LocalDate calcularFechaLlegada(Double diasHabiles){
		LocalDate result = LocalDate.now();
		int addedDays = 0;
		while (addedDays < diasHabiles) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}

	private BigDecimal calcularCosto(Double peso, BigDecimal costo){
		BigDecimal pesoEnvio = new BigDecimal(peso);
		return costo.multiply(pesoEnvio) ;
	}
}
