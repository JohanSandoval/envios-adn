package com.ceiba.envio.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

	@SqlStatement(namespace = "envio", value = "actualizar")
	private static String sqlActualizar;

	@Autowired
	public RepositorioEnvioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	private SqlParameterSource obtenerParametrosEnvio(Envio envio){
		return  new MapSqlParameterSource()
				.addValue("id",envio.getId())
				.addValue("idRemitente", envio.getRemitente().getId())
				.addValue("idDestinatario", envio.getDestinatario().getId())
				.addValue("peso", envio.getPeso())
				.addValue("costo", envio.getCosto())
				.addValue("fechaLlegada", envio.getFechaEstimadaLlegada())
				.addValue("direccion", envio.getDireccion());
	}

	@Override
	public Long crear(Envio envio) {
		SqlParameterSource parameterSource = this.obtenerParametrosEnvio(envio);
		return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
	}

	@Override
	public void actualizar(Envio envio) {
		SqlParameterSource parameterSource = this.obtenerParametrosEnvio(envio);
		this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
	}
}
