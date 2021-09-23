package com.ceiba.destinatario.adaptador.dao;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDestinatario implements RowMapper<DtoDestinatario>, MapperResult {

    @Override
    public DtoDestinatario mapRow(ResultSet resultSet, int rowNum)throws SQLException{
        Long id = resultSet.getLong("id");
        String cedula = resultSet.getString("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        Ciudad ciudad = Ciudad.valueOf(resultSet.getString("ciudad"));
        String direccion = resultSet.getString("direccion");

        return new DtoDestinatario(id, cedula, nombre, apellido, ciudad, direccion);
    }

}
