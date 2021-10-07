package com.ceiba.costo_envio.adaptador.dao;

import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;
import com.ceiba.costo_envio.puerto.dao.DaoCostoEnvio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCostoEnvioMySql implements DaoCostoEnvio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "costoEnvio", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "costoEnvio", value = "listarById")
    private static String sqlListarById;

    public DaoCostoEnvioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCostoEnvio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoCostoEnvio());
    }

    @Override
    public List<DtoCostoEnvio> listarById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarById, parameterSource, new MapeoCostoEnvio());
    }
}
