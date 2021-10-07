package com.ceiba.ciudad.adaptador.repositorio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadCiudad implements RowMapper<Ciudad>, MapperResult {

    @Override
    public Ciudad mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        return new Ciudad(id, nombre);
    }
}
