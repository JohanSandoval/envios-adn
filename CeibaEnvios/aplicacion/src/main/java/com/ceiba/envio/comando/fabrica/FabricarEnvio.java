package com.ceiba.envio.comando.fabrica;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.modelo.entidad.Envio;

@Component
public class FabricarEnvio {

	public Envio crear(ComandoEnvio comandoEnvio, RepositorioUsuario repositorioUsuario,
					   RepositorioCostoEnvio repositorioCostoEnvio, RepositorioDiasEspera repositorioDiasEspera) {

		Usuario remitente = repositorioUsuario.optenerPorCedula(comandoEnvio.getCedulaRemitente());
		Usuario destinatario = repositorioUsuario.optenerPorCedula(comandoEnvio.getCedulaDestinatario());
		CostoEnvio costoEnvio = repositorioCostoEnvio.optenerPorPeso(comandoEnvio.getPeso());
		DiasEspera diasEspera = repositorioDiasEspera.optenerPorId(remitente.getCiudad().getId(), destinatario.getCiudad().getId());

		return new Envio(
				comandoEnvio.getId(),
				remitente,
				destinatario,
				comandoEnvio.getPeso(),
				costoEnvio.getCosto(),
				diasEspera.getDias(),
				comandoEnvio.getDireccion());
	}
	
}
