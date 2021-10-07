package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoUsuarioMySql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "usuario", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "usuario", value = "listarByCedula")
    private static String sqlListarByCedula;

    public DaoUsuarioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoUsuario());
    }

    @Override
    public List<DtoUsuario> listarByCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarByCedula, parameterSource, new MapeoUsuario());
    }
}
