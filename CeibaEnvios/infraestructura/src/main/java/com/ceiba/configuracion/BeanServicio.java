package com.ceiba.configuracion;

import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.ciudad.servicio.ServicioActualizarCiudad;
import com.ceiba.ciudad.servicio.ServicioCrearCiudad;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioActualizarCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioCrearCostoEnvio;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.dias_espera.servicio.ServicioActualizarDiasEspera;
import com.ceiba.dias_espera.servicio.ServicioCrearDiasEspera;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.envio.servicio.ServicioActualizarEnvio;
import com.ceiba.envio.servicio.ServicioCrearEnvio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearEnvio servicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
		return new ServicioCrearEnvio(repositorioEnvio);
	}

	@Bean
	public ServicioActualizarEnvio servicioActualizarEnvio(RepositorioEnvio repositorioEnvio) {
		return new ServicioActualizarEnvio(repositorioEnvio);
	}

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario){
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario){
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioCrearCiudad servicioCrearCiudad(RepositorioCiudad repositorioCiudad){
		return new ServicioCrearCiudad(repositorioCiudad);
	}

	@Bean
	public ServicioActualizarCiudad servicioActualizarCiudad(RepositorioCiudad repositorioCiudad){
		return new ServicioActualizarCiudad(repositorioCiudad);
	}

	@Bean
	public ServicioCrearDiasEspera servicioCrearDiasEspera(RepositorioDiasEspera repositorioDiasEspera){
		return new ServicioCrearDiasEspera(repositorioDiasEspera);
	}

	@Bean
	public ServicioActualizarDiasEspera servicioActualizarDiasEspera(RepositorioDiasEspera repositorioDiasEspera){
		return new ServicioActualizarDiasEspera(repositorioDiasEspera);
	}

	@Bean
	public ServicioCrearCostoEnvio servicioCrearCostoEnvio(RepositorioCostoEnvio repositorioCostoEnvio){
		return new ServicioCrearCostoEnvio(repositorioCostoEnvio);
	}

	@Bean
	public ServicioActualizarCostoEnvio servicioActualizarCostoEnvio(RepositorioCostoEnvio repositorioCostoEnvio){
		return new ServicioActualizarCostoEnvio(repositorioCostoEnvio);
	}

}
