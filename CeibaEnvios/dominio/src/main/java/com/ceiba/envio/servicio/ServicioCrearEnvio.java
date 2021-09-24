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
		return this.repositorioEnvio.crear(envio);
	}

}
