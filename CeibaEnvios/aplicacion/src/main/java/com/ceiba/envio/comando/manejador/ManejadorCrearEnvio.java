package com.ceiba.envio.comando.manejador;

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
	
	public ManejadorCrearEnvio(FabricarEnvio fabricarEnvio, ServicioCrearEnvio servicioCrearEnvio) {
		this.fabricarEnvio = fabricarEnvio;
		this.servicioCrearEnvio = servicioCrearEnvio;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoEnvio comandoEnvio) {
		Envio envio = this.fabricarEnvio.crear(comandoEnvio);
		return new ComandoRespuesta<>(this.servicioCrearEnvio.ejecutar(envio));
	}
}
