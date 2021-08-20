package com.ceiba.configuracion;

import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.envio.servicio.ServicioActualizarEnvio;
import com.ceiba.envio.servicio.ServicioCrearEnvio;
import com.ceiba.envio.servicio.ServicioEliminarEnvio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

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
}
