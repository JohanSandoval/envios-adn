package com.ceiba.envio.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEnvio implements RowMapper<DtoEnvio>, MapperResult  {

	@Override
	public DtoEnvio mapRow(ResultSet resultSet, int rowNum) throws SQLException{

		Long idRemitente = resultSet.getLong("id_usuario_remitente");
		String cedulaRemitente = resultSet.getString("cedula_remitente");
		String nombreRemitente = resultSet.getString("nombre_remitente");
		String apellidoRemitente = resultSet.getString("apellido_remitente");
		String telefonoRemitente = resultSet.getString("telefono_remitente");

		Long idCiudadResmitente = resultSet.getLong("id_ciudad_remitente");
		String nombreCiudadremitente = resultSet.getString("nombre_ciudad_remitente");
		DtoCiudad ciudadRemitente = new DtoCiudad(idCiudadResmitente,nombreCiudadremitente);

		DtoUsuario remitente = new DtoUsuario(idRemitente, cedulaRemitente, nombreRemitente, apellidoRemitente,
				ciudadRemitente,telefonoRemitente);

		Long idDestinatario = resultSet.getLong("id_usuario_destinatario");
		String cedulaDestinatario = resultSet.getString("cedula_destinatario");
		String nombreDestinatario = resultSet.getString("nombre_destinatario");
		String apellidoDestinatario = resultSet.getString("apellido_destinatario");
		String telefonoDestinatario = resultSet.getString("telefono_destinatario");

		Long  idCiudadDestinatario = resultSet.getLong("id_ciudad_destinatario");
		String nombreCiudadDestinatario = resultSet.getString("nombre_ciudad_destinatario");
		DtoCiudad ciudadDestinatario = new DtoCiudad(idCiudadDestinatario, nombreCiudadDestinatario);

		DtoUsuario destinatario = new DtoUsuario(idDestinatario, cedulaDestinatario, nombreDestinatario,
				apellidoDestinatario, ciudadDestinatario, telefonoDestinatario);

		Long id = resultSet.getLong("id");
		double peso = resultSet.getDouble("peso");
		BigDecimal costo = resultSet.getBigDecimal("costo");
		LocalDate fechaLlegada = resultSet.getObject("fecha_llegada", LocalDate.class);
		String direccion = resultSet.getString("direccion");

		return new DtoEnvio(id, remitente, destinatario, peso, costo, fechaLlegada, direccion);
	}
}
