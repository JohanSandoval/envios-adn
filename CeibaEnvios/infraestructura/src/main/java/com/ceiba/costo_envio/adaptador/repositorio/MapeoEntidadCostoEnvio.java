package com.ceiba.costo_envio.adaptador.repositorio;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadCostoEnvio implements RowMapper<CostoEnvio>, MapperResult {

    @Override
    public CostoEnvio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Double pesoMaximo = rs.getDouble("peso_maximo");
        Double pesoMinimo = rs.getDouble("peso_minimo");
        BigDecimal costo = rs.getBigDecimal("costo");
        return new CostoEnvio(id, pesoMinimo, pesoMaximo, costo);
    }
}
