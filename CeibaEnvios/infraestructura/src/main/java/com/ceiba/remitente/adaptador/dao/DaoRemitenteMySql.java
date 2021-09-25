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

    @SqlStatement(namespace="remitente", value="listarByCedula")
    private static String sqlListarByCedula;

    public DaoRemitenteMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRemitente> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRemitente());
    }

    @Override
    public List<DtoRemitente> listarByCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        return  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarByCedula, parameterSource, new MapeoRemitente());
    }
}
