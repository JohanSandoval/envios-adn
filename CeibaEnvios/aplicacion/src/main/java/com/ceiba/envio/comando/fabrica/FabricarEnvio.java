package com.ceiba.envio.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.modelo.entidad.Envio;

@Component
public class FabricarEnvio {

	public Envio crear(ComandoEnvio comandoEnvio) {
		return new Envio(
				comandoEnvio.getNombre(),
				comandoEnvio.getApellido(),
				comandoEnvio.getTelefono(),
				comandoEnvio.getCiudadOrigen(),
				comandoEnvio.getCiudadDestino(),
				comandoEnvio.getPeso());
	}
	
}
