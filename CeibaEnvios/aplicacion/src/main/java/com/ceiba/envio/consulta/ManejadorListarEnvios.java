package com.ceiba.envio.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.envio.puerto.dao.DaoEnvio;

@Component
public class ManejadorListarEnvios {
	
	private final DaoEnvio daoEnvio;

	public ManejadorListarEnvios(DaoEnvio daoEnvio) {
		this.daoEnvio = daoEnvio;
	}
	
	public List<DtoEnvio> ejecutar(){ return this.daoEnvio.listar();}

}
