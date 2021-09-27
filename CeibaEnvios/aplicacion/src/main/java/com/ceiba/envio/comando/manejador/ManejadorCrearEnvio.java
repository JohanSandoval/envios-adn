package com.ceiba.envio.comando.manejador;

import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
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
	private final RepositorioRemitente repositorioRemitente;
	private final RepositorioDestinatario repositorioDestinatario;

	public ManejadorCrearEnvio(FabricarEnvio fabricarEnvio, ServicioCrearEnvio servicioCrearEnvio,
							   RepositorioRemitente repositorioRemitente, RepositorioDestinatario repositorioDestinatario) {
		this.fabricarEnvio = fabricarEnvio;
		this.servicioCrearEnvio = servicioCrearEnvio;
		this.repositorioRemitente = repositorioRemitente;
		this.repositorioDestinatario = repositorioDestinatario;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoEnvio comandoEnvio) {
		Envio envio = this.fabricarEnvio.crear(comandoEnvio, this.repositorioRemitente, this.repositorioDestinatario);
		System.out.println(envio.toString());
		return new ComandoRespuesta<>(this.servicioCrearEnvio.ejecutar(envio));
	}
}
