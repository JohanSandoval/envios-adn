package com.ceiba.usuario.adaptador.dao;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String telefono = resultSet.getString("telefono");

        Long idCiudad = resultSet.getLong("id_ciudad");
        String NombreCiudad = resultSet.getString("nombre_ciudad");
        DtoCiudad ciudad = new DtoCiudad(idCiudad, NombreCiudad);

        return new DtoUsuario(id, cedula, nombre, apellido, ciudad, telefono);
    }
}
