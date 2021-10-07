package com.ceiba.costo_envio.adaptador.dao;

import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCostoEnvio implements RowMapper<DtoCostoEnvio>, MapperResult {

    @Override
    public DtoCostoEnvio mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Double pesoMaximo = rs.getDouble("peso_maximo");
        Double pesoMinimo = rs.getDouble("peso_minimo");
        BigDecimal costo = rs.getBigDecimal("costo");

        return new DtoCostoEnvio(id, pesoMinimo, pesoMaximo, costo) ;
    }
}
