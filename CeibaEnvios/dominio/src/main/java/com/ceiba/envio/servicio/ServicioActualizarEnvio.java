package com.ceiba.envio.servicio;

import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;

public class ServicioActualizarEnvio {
	
	private final RepositorioEnvio repositorioEnvio;

	public ServicioActualizarEnvio(RepositorioEnvio repositorioEnvio) {
		super();
		this.repositorioEnvio = repositorioEnvio;
	}
	
	public void ejecutar(Envio envio) {
		repositorioEnvio.actualizar(envio);
	}
	
	
}
