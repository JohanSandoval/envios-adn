package com.ceiba.envio.modelo.entidad;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.enumeraciones.CostoPorPeso;
import com.ceiba.remitente.modelo.entidad.Remitente;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.DayOfWeek;
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

	public Envio(Long id, Remitente remitente, Destinatario destinatario, double peso){

		validarObligatorio(remitente, REMITENTE_OBLIGATORIO);
		validarObligatorio(destinatario, DESTINARTARIO_OBLIGATORIO);
		validarObligatorio(peso, PESO_OBLIGATORIO);
		validarMenor((long) peso, PESO_MAXIMO, PESO_MENOR_50);
		validarPositivo(peso, PESO_MAYOR_0);

		this.id = id;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.peso = peso;
		this.obtenerCosto(peso);
		this.fechaEstimadaLlegada = calcularFecha(remitente.getCiudad(), destinatario.getCiudad());
	}

	private LocalDate calcularFecha(Ciudad origen, Ciudad destino){
		int diasHabiles = calcularDiasHabiles(origen, destino);
		return calcularFechaLlegada(diasHabiles);
	}

	private int calcularDiasHabiles(Ciudad ciudadOrigen, Ciudad ciudadDestino){
		int diasHabilesEnvio = 0;

		switch (ciudadOrigen) {
			case BOGOTA:
				if(ciudadDestino.equals(Ciudad.BOGOTA)){
					diasHabilesEnvio = 2;
				}else if(ciudadDestino.equals(Ciudad.CALI)){
					diasHabilesEnvio = 3;
				}else if (ciudadDestino.equals(Ciudad.MEDELLIN)){
					diasHabilesEnvio = 5;
				}
				break;
			case MEDELLIN:
				if(ciudadDestino.equals(Ciudad.BOGOTA)){
					diasHabilesEnvio = 5;
				}else if(ciudadDestino.equals(Ciudad.CALI)){
					diasHabilesEnvio = 3;
				}else if (ciudadDestino.equals(Ciudad.MEDELLIN)){
					diasHabilesEnvio = 2;
				}
				break;
			case CALI:
				if(ciudadDestino.equals(Ciudad.BOGOTA)){
					diasHabilesEnvio = 3;
				}else if(ciudadDestino.equals(Ciudad.CALI)){
					diasHabilesEnvio = 2;
				}else if (ciudadDestino.equals(Ciudad.MEDELLIN)){
					diasHabilesEnvio = 3;
				}
				break;
			default:
				diasHabilesEnvio = 0;
				break;
		}
		return diasHabilesEnvio;
	}

	private LocalDate calcularFechaLlegada(int diasHabiles){
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

	private CostoPorPeso calcularPresioKl(Double peso){

		CostoPorPeso costoPorPeso = CostoPorPeso.MAYOR_O_MENOR_10;

		if(peso >= 10){
			costoPorPeso = CostoPorPeso.MAYOR_IGUAL_10_MENOR_20;
		}

		if(peso >= 20){
			costoPorPeso = CostoPorPeso.MAYOR_IGUAL_20_MENOR_30;
		}
		if(peso >= 30){
			costoPorPeso = CostoPorPeso.MAYOR_IGUAL_30_MENOR_40;
		}
		if(peso >= 40){
			costoPorPeso = CostoPorPeso.MAYOR_IGUAL_40_MENOR_50;
		}
		return costoPorPeso;
	}

	private void obtenerCosto(double peso){
		CostoPorPeso costoPorPeso = this.calcularPresioKl(peso);
		this.costo = costoPorPeso.calcularCosto(peso);
	}


}
