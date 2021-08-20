package com.ceiba.envio.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.envio.puerto.dao.DaoEnvio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoEnvioMysql implements DaoEnvio {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="envio", value="listar")
	private static String sqlListar;

	@SqlStatement(namespace="envio", value="listarById")
	private static String sqlListarById;

	public DaoEnvioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@Override
	public List<DtoEnvio> listar(){
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEnvio());
	}

	@Override
	public List<DtoEnvio> listarById(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarById, paramSource, new MapeoEnvio());
	}


}
