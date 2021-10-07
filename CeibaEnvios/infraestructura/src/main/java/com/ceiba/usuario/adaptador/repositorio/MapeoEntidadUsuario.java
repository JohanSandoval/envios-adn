package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadUsuario implements RowMapper<Usuario>, MapperResult {

    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String telefono = resultSet.getString("telefono");

        Long idCiudad = resultSet.getLong("id_Ciudad");
        String nombreCiudad = resultSet.getString("nombre_ciudad");
        Ciudad ciudad = new Ciudad(idCiudad, nombreCiudad);

        return new Usuario(id, cedula, nombre, apellido, ciudad, telefono);
    }
}
