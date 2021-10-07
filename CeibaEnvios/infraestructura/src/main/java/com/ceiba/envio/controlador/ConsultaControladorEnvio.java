package com.ceiba.envio.controlador;

import java.util.List;

import com.ceiba.envio.consulta.ManejadorBuscarEnvio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.envio.consulta.ManejadorListarEnvios;
import com.ceiba.envio.modelo.dto.DtoEnvio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/envio")
@Api(tags = {"Controlador consulta envio"})
public class ConsultaControladorEnvio {

	private final ManejadorListarEnvios manejadorListarEnvios;

	private final ManejadorBuscarEnvio manejadorBuscarEnvio;

	public ConsultaControladorEnvio(ManejadorListarEnvios manejadorListarEnvios, ManejadorBuscarEnvio manejadorBuscarEnvio) {
		this.manejadorListarEnvios = manejadorListarEnvios;
		this.manejadorBuscarEnvio = manejadorBuscarEnvio;
	}

	@GetMapping
	@ApiOperation("Listar Envios")
	public List<DtoEnvio> listar(){
		return this.manejadorListarEnvios.ejecutar();
	}

	@GetMapping(value="/{id}")
	@ApiOperation("Listar por id")
	public List<DtoEnvio> listarById(@PathVariable Long id){
		return  this.manejadorBuscarEnvio.ejecutar(id);
	}

}
