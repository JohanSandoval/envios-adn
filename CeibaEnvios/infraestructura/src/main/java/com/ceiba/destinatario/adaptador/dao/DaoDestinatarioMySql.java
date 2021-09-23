package com.ceiba.destinatario.adaptador.dao;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.destinatatio.puerto.dao.DaoDestinatario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDestinatarioMySql implements DaoDestinatario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "destinatario", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "destinatario", value = "listarById")
    private static String sqlListarById;

    public DaoDestinatarioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDestinatario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDestinatario());
    }

    @Override
    public List<DtoDestinatario> listarById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarById, parameterSource, new MapeoDestinatario());
    }
}
