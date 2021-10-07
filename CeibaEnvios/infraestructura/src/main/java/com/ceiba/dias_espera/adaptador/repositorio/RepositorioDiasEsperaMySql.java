package com.ceiba.dias_espera.adaptador.repositorio;

import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioDiasEsperaMySql implements RepositorioDiasEspera {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioDiasEsperaMySql.class.getName());

    @SqlStatement(namespace = "diasEspera", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "diasEspera", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "diasEspera", value = "optenerPorIdsCiudades")
    private static String sqlOptenerPorIdsCiudades;

    @SqlStatement(namespace = "diasEspera", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "diasEspera", value = "existeExculyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioDiasEsperaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource optenerParametrosDiasEspera(DiasEspera diasEspera){
        return new MapSqlParameterSource()
                .addValue("id", diasEspera.getId())
                .addValue("idCiudadO", diasEspera.getCiudadOrigen().getId())
                .addValue("idCiudadD", diasEspera.getCiudadDestino().getId())
                .addValue("dias", diasEspera.getDias());
    }

    @Override
    public Long crear(DiasEspera diasEspera) {
        SqlParameterSource parameterSource = this.optenerParametrosDiasEspera(diasEspera);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void actualizar(DiasEspera diasEspera) {
        SqlParameterSource parameterSource = this.optenerParametrosDiasEspera(diasEspera);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
    }

    @Override
    public boolean existe(Long ciudadO, Long ciudadD) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idCiudadO", ciudadO);
        parameterSource.addValue("idCiudadD", ciudadD);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long ciudadO, Long ciudadD) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("idCiudadO", ciudadO);
        parameterSource.addValue("idCiudadD", ciudadD);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }

    @Override
    public DiasEspera optenerPorId(Long idCiudadO, Long idCiudadD ) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idCiudadO", idCiudadO);
        parameterSource.addValue("idCiudadD", idCiudadD);
        try{
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlOptenerPorIdsCiudades, parameterSource, new MapeoEntidadDiasEspera());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }
}
