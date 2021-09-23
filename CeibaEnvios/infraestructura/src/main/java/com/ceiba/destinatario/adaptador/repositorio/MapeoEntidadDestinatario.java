package com.ceiba.destinatario.adaptador.repositorio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadDestinatario implements RowMapper<Destinatario>, MapperResult {

    @Override
    public Destinatario mapRow(ResultSet resultSet, int rowNum) throws SQLException{

        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        Ciudad ciudad = Ciudad.valueOf(resultSet.getString("ciudad"));
        String direccion = resultSet.getString("direccion");

        return new Destinatario(id, cedula, nombre, apellido, ciudad, direccion);
    }

}
