package com.ceiba.envio.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEnvio implements RowMapper<DtoEnvio>, MapperResult  {

	@Override
	public DtoEnvio mapRow(ResultSet resultSet, int rowNum) throws SQLException{
		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		String telefono = resultSet.getString("telefono");
		int ciudadOrigen = resultSet.getInt("ciudad_origen_id");
		int ciudadDestino = resultSet.getInt("ciudad_destino_id");
		Double peso = resultSet.getDouble("peso");
		Double costo = resultSet.getDouble("costo");
		String fechaLlegada = resultSet.getString("fecha_llegada");

		return new DtoEnvio(id, nombre, apellido, telefono, ciudadOrigen, ciudadDestino, peso, costo, fechaLlegada);
	}
}
