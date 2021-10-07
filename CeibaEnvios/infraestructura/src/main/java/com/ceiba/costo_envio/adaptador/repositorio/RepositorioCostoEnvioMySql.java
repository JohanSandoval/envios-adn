package com.ceiba.costo_envio.adaptador.repositorio;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioCostoEnvioMySql implements RepositorioCostoEnvio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioCostoEnvio.class.getName());

    @SqlStatement(namespace = "costoEnvio", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "costoEnvio", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "costoEnvio", value = "optenerPorPeso")
    private static String sqlOptenerPorPeso;

    @SqlStatement(namespace = "costoEnvio", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "costoEnvio", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCostoEnvioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource optenerParametrosCostoEnvio(CostoEnvio costoEnvio){
        return new MapSqlParameterSource()
                .addValue("id", costoEnvio.getId())
                .addValue("pesoMin", costoEnvio.getPesoMin())
                .addValue("pesoMax", costoEnvio.getPesoMax())
                .addValue("costo", costoEnvio.getCosto());
    }

    @Override
    public Long crear(CostoEnvio costoEnvio) {
        SqlParameterSource parameterSource = this.optenerParametrosCostoEnvio(costoEnvio);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void actualizar(CostoEnvio costoEnvio) {
        SqlParameterSource parameterSource = this.optenerParametrosCostoEnvio(costoEnvio);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
    }

    @Override
    public boolean existe(Double pesoMin, Double pesoMax) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("pesoMin", pesoMin);
        parameterSource.addValue("pesoMax", pesoMax);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Double pesoMin, Double pesoMax) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("pesoMin", pesoMin);
        parameterSource.addValue("pesoMax", pesoMax);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }

    @Override
    public CostoEnvio optenerPorPeso(Double peso) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("peso", peso);
        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlOptenerPorPeso, parameterSource, new MapeoEntidadCostoEnvio());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }
}
