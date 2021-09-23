package com.ceiba.remitente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.remitente.modelo.dto.DtoRemitente;
import com.ceiba.remitente.puerto.dao.DaoRemitente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoRemitenteMySql implements DaoRemitente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="remitente", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="remitente", value="listarById")
    private static String sqlListarById;

    public DaoRemitenteMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRemitente> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRemitente());
    }

    @Override
    public List<DtoRemitente> listarById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarById, parameterSource, new MapeoRemitente());
    }
}
