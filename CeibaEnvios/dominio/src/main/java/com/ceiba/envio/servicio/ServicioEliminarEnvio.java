package com.ceiba.envio.servicio;

import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;

public class ServicioEliminarEnvio {
	
	
	private final RepositorioEnvio repositorioEnvio;

	public ServicioEliminarEnvio(RepositorioEnvio repositorioEnvio) {
		super();
		this.repositorioEnvio = repositorioEnvio;
	}
	
	public void ejecutar(Long id) {
		this.repositorioEnvio.eliminar(id);
	}

}
