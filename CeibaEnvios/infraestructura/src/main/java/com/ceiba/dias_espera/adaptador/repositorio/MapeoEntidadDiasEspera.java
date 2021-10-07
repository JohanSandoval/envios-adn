package com.ceiba.dias_espera.adaptador.repositorio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadDiasEspera implements RowMapper<DiasEspera>, MapperResult {

    @Override
    public DiasEspera mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Double dias = resultSet.getDouble("dias");

        Long idCiudadO = resultSet.getLong("id_ciudad_origen");
        String nombreCiudadO = resultSet.getString("nombre_ciudad_origen");
        Ciudad ciudadO = new Ciudad(idCiudadO, nombreCiudadO);

        Long idCiudadD = resultSet.getLong("id_ciudad_destino");
        String nombreCiudadD = resultSet.getString("nombre_ciudad_destino");
        Ciudad ciudadD = new Ciudad(idCiudadD, nombreCiudadD);

        return new DiasEspera(id, ciudadO, ciudadD, dias);
    }
}
