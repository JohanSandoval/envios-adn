package com.ceiba.envio.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.remitente.modelo.dto.DtoRemitente;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEnvio implements RowMapper<DtoEnvio>, MapperResult  {

	@Override
	public DtoEnvio mapRow(ResultSet resultSet, int rowNum) throws SQLException{

		Long idRemitente = resultSet.getLong("id_remitente");
		String cedulaRemitente = resultSet.getString("cedula_remitente");
		String nombreRemitente = resultSet.getString("nombre_remitente");
		String apellidoRemitente = resultSet.getString("apellido_remitente");
		Ciudad ciudadRemitente = Ciudad.valueOf(resultSet.getString("ciudad_remitente"));
		String telefonoRemitente = resultSet.getString("telefono_remitente");
		DtoRemitente remitente = new DtoRemitente(idRemitente, cedulaRemitente, nombreRemitente, apellidoRemitente, ciudadRemitente,telefonoRemitente);

		Long id = resultSet.getLong("id");
		Long idDestinatario = resultSet.getLong("id_destinatario");
		String cedulaDestinatario = resultSet.getString("cedula_destinatario");
		String nombreDestinatario = resultSet.getString("nombre_destinatario");
		String apellidoDestinatario = resultSet.getString("apellido_destinatario");
		Ciudad ciudadDestinatario = Ciudad.valueOf(resultSet.getString("ciudad_destinatario"));
		String direccionDestinatario = resultSet.getString("direccion_destinatario");
		DtoDestinatario destinatario = new DtoDestinatario(idDestinatario, cedulaDestinatario, nombreDestinatario, apellidoDestinatario, ciudadDestinatario, direccionDestinatario);

		double peso = resultSet.getDouble("peso");
		BigDecimal costo = resultSet.getBigDecimal("costo");
		LocalDate fechaLlegada = resultSet.getObject("fecha_llegada", LocalDate.class);

		return new DtoEnvio(id, remitente,destinatario,peso,costo,fechaLlegada);
	}
}
