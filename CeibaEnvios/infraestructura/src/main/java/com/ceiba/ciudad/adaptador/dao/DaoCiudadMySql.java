package com.ceiba.ciudad.adaptador.dao;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCiudadMySql implements DaoCiudad {

    private  final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ciudad", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "ciudad", value = "listarById")
    private static String sqlListarById;

    public DaoCiudadMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCiudad> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCiudad());
    }

    @Override
    public List<DtoCiudad> listarById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarById, parameterSource, new MapeoCiudad());
    }
}
