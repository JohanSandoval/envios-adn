package com.ceiba.configuracion;

import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.destinatatio.servicio.ServicioActualizarDestinatario;
import com.ceiba.destinatatio.servicio.ServicioCrearDestinatario;
import com.ceiba.destinatatio.servicio.ServicioEliminarDestinatario;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.envio.servicio.ServicioActualizarEnvio;
import com.ceiba.envio.servicio.ServicioCrearEnvio;
import com.ceiba.envio.servicio.ServicioEliminarEnvio;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.ServicioActualizarRemitente;
import com.ceiba.remitente.servicio.ServicioCrearRemitente;
import com.ceiba.remitente.servicio.ServicioEliminarRemitente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearEnvio servicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
		return new ServicioCrearEnvio(repositorioEnvio);
	}

	@Bean
	public ServicioEliminarEnvio servicioEliminarEnvio(RepositorioEnvio repositorioEnvio) {
		return new ServicioEliminarEnvio(repositorioEnvio);
	}

	@Bean
	public ServicioActualizarEnvio servicioActualizarEnvio(RepositorioEnvio repositorioEnvio) {
		return new ServicioActualizarEnvio(repositorioEnvio);
	}

	@Bean
	public ServicioCrearRemitente servicioCrearRemitente(RepositorioRemitente repositorioRemitente){
		return  new ServicioCrearRemitente(repositorioRemitente);
	}

	@Bean
	public ServicioActualizarRemitente servicioActualizarRemitente(RepositorioRemitente repositorioRemitente){
		return  new ServicioActualizarRemitente(repositorioRemitente);
	}

	@Bean
	public ServicioEliminarRemitente servicioEliminarRemitente(RepositorioRemitente repositorioRemitente){
		return new ServicioEliminarRemitente(repositorioRemitente);
	}

	@Bean
	public ServicioCrearDestinatario servicioCrearDestinatario(RepositorioDestinatario repositorioDestinatario){
		return new ServicioCrearDestinatario(repositorioDestinatario);
	}

	@Bean
	public ServicioActualizarDestinatario servicioActualizarDestinatario(RepositorioDestinatario repositorioDestinatario){
		return  new ServicioActualizarDestinatario(repositorioDestinatario);
	}

	@Bean
	public ServicioEliminarDestinatario servicioEliminarDestinatario(RepositorioDestinatario repositorioDestinatario){
		return new ServicioEliminarDestinatario(repositorioDestinatario);
	}
}
