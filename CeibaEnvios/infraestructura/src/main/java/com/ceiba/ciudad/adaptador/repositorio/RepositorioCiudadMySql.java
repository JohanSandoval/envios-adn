package com.ceiba.ciudad.adaptador.repositorio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioCiudadMySql implements RepositorioCiudad {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioCiudadMySql.class.getName());

    @SqlStatement(namespace = "ciudad", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "ciudad", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "ciudad", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "ciudad", value = "optenerPorId")
    private static String sqlOptenerPorId;

    @SqlStatement(namespace = "ciudad", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCiudadMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosCiudad(Ciudad ciudad){
        return new MapSqlParameterSource()
                .addValue("id", ciudad.getId())
                .addValue("nombre", ciudad.getNombre());
    }


    @Override
    public Long crear(Ciudad ciudad) {
        SqlParameterSource parameterSource = this.obtenerParametrosCiudad(ciudad);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void actualizar(Ciudad ciudad) {
        SqlParameterSource parameterSource = this.obtenerParametrosCiudad(ciudad);
        System.out.println(ciudad);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }

    @Override
    public Ciudad optenerPorId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        try{
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlOptenerPorId, parameterSource, new MapeoEntidadCiudad());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }
}
