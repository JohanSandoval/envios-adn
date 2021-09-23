package com.ceiba.remitente.adaptador.dao;

import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.remitente.modelo.dto.DtoRemitente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoRemitente implements RowMapper<DtoRemitente>, MapperResult {

    @Override
    public DtoRemitente mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String ciudad = resultSet.getString("ciudad");
        String telefono = resultSet.getString("telefono");

        return  new DtoRemitente(id, cedula, nombre, apellido, Ciudad.valueOf(ciudad), telefono);
    }
}
