package com.ceiba.envio.comando.fabrica;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import org.springframework.stereotype.Component;

import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.modelo.entidad.Envio;

@Component
public class FabricarEnvio {

	public Envio crear(ComandoEnvio comandoEnvio, RepositorioRemitente repositorioRemitente,
					   RepositorioDestinatario repositorioDestinatario) {

		Remitente remitente = repositorioRemitente.optenerPorCedula(comandoEnvio.getCedulaRemitente());
		Destinatario destinatario = repositorioDestinatario.optenerPorCedula(comandoEnvio.getCedulaDestinatario());

		return new Envio(
				comandoEnvio.getId(),
				remitente,
				destinatario,
				comandoEnvio.getPeso());
	}
	
}
