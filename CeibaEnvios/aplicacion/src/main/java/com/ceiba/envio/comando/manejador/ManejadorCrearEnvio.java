package com.ceiba.envio.comando.manejador;

import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.comando.fabrica.FabricarEnvio;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.servicio.ServicioCrearEnvio;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearEnvio implements ManejadorComandoRespuesta<ComandoEnvio, ComandoRespuesta<Long>>{
	
	private final FabricarEnvio fabricarEnvio;
	private final ServicioCrearEnvio servicioCrearEnvio;
	private final RepositorioUsuario repositorioUsuario;
	private final RepositorioCostoEnvio repositorioCostoEnvio;
	private final RepositorioDiasEspera repositorioDiasEspera;

	public ManejadorCrearEnvio(FabricarEnvio fabricarEnvio, ServicioCrearEnvio servicioCrearEnvio,
							   RepositorioUsuario repositorioUsuario, RepositorioCostoEnvio repositorioCostoEnvio,
							   RepositorioDiasEspera repositorioDiasEspera) {
		this.fabricarEnvio = fabricarEnvio;
		this.servicioCrearEnvio = servicioCrearEnvio;
		this.repositorioUsuario = repositorioUsuario;
		this.repositorioCostoEnvio = repositorioCostoEnvio;
		this.repositorioDiasEspera = repositorioDiasEspera;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoEnvio comandoEnvio) {
		Envio envio = this.fabricarEnvio.crear(comandoEnvio, this.repositorioUsuario,
				this.repositorioCostoEnvio, this.repositorioDiasEspera);
		return new ComandoRespuesta<>(servicioCrearEnvio.ejecutar(envio));
	}
}
