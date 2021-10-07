package com.ceiba.dias_espera.adaptador.dao;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDiasEspera implements RowMapper<DtoDiasEspera>, MapperResult {

    @Override
    public DtoDiasEspera mapRow(ResultSet resultSet, int rowNum) throws SQLException{

        Long id = resultSet.getLong("id");
        int dias = resultSet.getInt("dias");

        Long idCiudadO = resultSet.getLong("id_ciudad_origen");
        String nombreCiudadO = resultSet.getString("nombreCiudadO");
        DtoCiudad ciudadO = new DtoCiudad(idCiudadO, nombreCiudadO);

        Long idCiudadD = resultSet.getLong("id_ciudad_destino");
        String nombreCiudadD = resultSet.getString("nombreCiudadD");
        DtoCiudad ciudadD = new DtoCiudad(idCiudadD, nombreCiudadD);

        return new DtoDiasEspera(id, ciudadO, ciudadD, dias);

    }

}
