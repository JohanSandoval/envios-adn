package com.ceiba.remitente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.remitente.modelo.entidad.Remitente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadRemitente implements RowMapper<Remitente>, MapperResult {

    @Override
    public Remitente mapRow(ResultSet resultSet, int rowNum) throws SQLException{

        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String ciudad = resultSet.getString("ciudad");
        String telefono = resultSet.getString("telefono");

        return new Remitente(id, cedula, nombre, apellido, ciudad, telefono);
    }
}
