package com.ceiba.envio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ceiba.ComandoRespuesta;
import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.comando.manejador.ManejadorCrearEnvio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/envios")
@Api(tags = { "Controlador comando envio"})
public class ComandoControladorEnvio {

	private final ManejadorCrearEnvio manejadorCrearEnvio;

	@Autowired
	public ComandoControladorEnvio(ManejadorCrearEnvio manejadorCrearEnvio) {
		this.manejadorCrearEnvio = manejadorCrearEnvio;
	}
	
	@PostMapping
	@ApiOperation("Crear Envio")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoEnvio comandoEnvio){
		return manejadorCrearEnvio.ejecutar(comandoEnvio);
	}

}
