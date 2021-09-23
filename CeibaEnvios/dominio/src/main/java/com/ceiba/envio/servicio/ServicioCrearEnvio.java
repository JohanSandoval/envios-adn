package com.ceiba.envio.servicio;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;

public class ServicioCrearEnvio {

	private final RepositorioEnvio repositorioEnvio;

	public ServicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
		this.repositorioEnvio = repositorioEnvio;
	}

	public Long ejecutar(Envio envio) {
		int numeroDiasHabiles = calculaDiasHabilesEnvio(envio.getRemitente().getCiudad(), envio.getDestinatario().getCiudad());
		BigDecimal costo = new BigDecimal( calcularCostoEnvio(envio.getPeso()));

		LocalDate fechaLlegada = LocalDate.now();
		fechaLlegada = calcularFechaLlegada(fechaLlegada, numeroDiasHabiles);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return this.repositorioEnvio.crear(new Envio(envio.getRemitente(), envio.getDestinatario(),
				envio.getPeso(), costo, fechaLlegada));
	}

	private int calculaDiasHabilesEnvio(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
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

	private double calcularCostoEnvio(double peso) {
		double costo = 123;

		return costo;
	}

	private LocalDate calcularFechaLlegada(LocalDate date, int diasHabiles) {
		LocalDate result = date;
        int addedDays = 0;
        while (addedDays < diasHabiles) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
	}
}
