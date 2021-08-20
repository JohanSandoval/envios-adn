package com.ceiba.envio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;

public class ServicioCrearEnvio {

	private final RepositorioEnvio repositorioEnvio;

	public ServicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
		this.repositorioEnvio = repositorioEnvio;
	}

	public Long ejecutar(Envio envio) {

		int numeroDiasHabiles = calculaDiasHabilesEnvio(envio.getCiudadOrigen(), envio.getCiudadDestino());
		double costo = calcularCostoEnvio(envio.getPeso());
		
		
		LocalDate fechaLlegada = LocalDate.now();
		fechaLlegada = calcularFechaLlegada(fechaLlegada, numeroDiasHabiles);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		

		return this.repositorioEnvio.crear(new Envio(envio.getNombre(), envio.getApellido(), envio.getTelefono(),
				envio.getCiudadOrigen(), envio.getCiudadDestino(), envio.getPeso(), costo, fechaLlegada.format(formato)));
	}

	private int calculaDiasHabilesEnvio(int ciudadOrigen, int ciudadDestino) {

		int diasHabilesEnvio = 0;

		if (ciudadOrigen == ciudadDestino) {
			diasHabilesEnvio = 2;
		} else if ((ciudadOrigen == 1 && ciudadDestino == 2)
				|| (ciudadOrigen == 2 && ciudadDestino ==1)) {
			diasHabilesEnvio = 3;
		} else if ((ciudadOrigen == 1 && ciudadDestino == 3)
				|| (ciudadOrigen == 3 && ciudadDestino ==1)) {
			diasHabilesEnvio = 5;
		} else if ((ciudadOrigen == 1 && ciudadDestino == 4)
				|| (ciudadOrigen == 4 && ciudadDestino ==1)) {
			diasHabilesEnvio = 7;
		}else {
			diasHabilesEnvio = 999;
		}

		return diasHabilesEnvio;
	}

	private double calcularCostoEnvio(double peso) {
		double costo = 0;

		if (peso > 0 && peso < 10) {
			costo = 10000;
		} else if (peso >= 10 && peso < 20) {
			costo = 15000;
		} else if (peso >= 20 && peso < 30) {
			costo = 20000;
		} else if (peso >= 30 && peso < 40) {
			costo = 25000;
		} else if (peso >= 40 && peso < 50) {
			costo = 30000;
		} else {
			costo = 9999999;
		}
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
