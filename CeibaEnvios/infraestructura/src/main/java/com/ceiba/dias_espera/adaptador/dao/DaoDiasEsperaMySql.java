package com.ceiba.dias_espera.adaptador.dao;

import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;
import com.ceiba.dias_espera.puerto.dao.DaoDiasEspera;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDiasEsperaMySql implements DaoDiasEspera {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "diasEspera", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "diasEspera", value = "listarById")
    private static String sqlListarById;

    public DaoDiasEsperaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDiasEspera> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoDiasEspera());
    }

    @Override
    public List<DtoDiasEspera> listarById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarById, parameterSource, new MapeoDiasEspera());
    }
}
