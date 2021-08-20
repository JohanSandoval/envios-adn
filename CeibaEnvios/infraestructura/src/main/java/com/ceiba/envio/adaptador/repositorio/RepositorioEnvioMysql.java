package com.ceiba.envio.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioEnvioMysql implements RepositorioEnvio {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "envio", value = "crear")
	private static String sqlCrear;

	@Autowired
	public RepositorioEnvioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Envio envio) {
		return this.customNamedParameterJdbcTemplate.crear(envio, sqlCrear);
	}

	@Override
	public void actualizar(Envio envio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existe(Envio nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeExcluyendoId(Long id, String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
