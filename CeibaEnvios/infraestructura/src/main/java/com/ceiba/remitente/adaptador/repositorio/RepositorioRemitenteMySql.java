package com.ceiba.remitente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioRemitenteMySql implements RepositorioRemitente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Regsitro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioRemitenteMySql.class.getName());

    @SqlStatement(namespace = "remitente", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "remitente", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "remitente", value = "optenerPorCedula")
    private static String sqlObtenerPorCedula;

    @SqlStatement(namespace = "remitente", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "remitente", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    private static String cedulaa = "cedula";

    public RepositorioRemitenteMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosRemitente(Remitente remitente){
        return  new MapSqlParameterSource()
                .addValue("id", remitente.getId())
                .addValue("cedula", remitente.getCedula())
                .addValue("nombre", remitente.getNombre())
                .addValue("apellido", remitente.getApellido())
                .addValue("ciudad", remitente.getCiudad().toString())
                .addValue("telefono", remitente.getTelefono());
    }

    @Override
    public Long crear(Remitente remitente) {
        SqlParameterSource parameterSource = this.obtenerParametrosRemitente(remitente);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void actualizar(Remitente remitente) {
        SqlParameterSource parameterSource = this.obtenerParametrosRemitente(remitente);

        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
    }

    @Override
    public Remitente optenerPorCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlObtenerPorCedula, parameterSource, new MapeoEntidadRemitente());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }


    @Override
    public boolean existe(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        System.out.println(cedula + " existe");
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }
}
