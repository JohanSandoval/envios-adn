package com.ceiba.destinatario.adaptador.repositorio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioDestinatarioMySql implements RepositorioDestinatario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioDestinatarioMySql.class.getName());

    @SqlStatement(namespace = "destinatario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "destinatario", value = "actualizar")
    private static String sqlActaulizar;

    @SqlStatement(namespace = "destinatario", value = "obtenerPorCedula")
    private static String sqlObtenerPorCedula;

    @Autowired
    public RepositorioDestinatarioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosDestinatario(Destinatario destinatario){
        return new MapSqlParameterSource()
                .addValue("id", destinatario.getId())
                .addValue("cedula", destinatario.getCedula())
                .addValue("nombre", destinatario.getNombre())
                .addValue("apellido", destinatario.getApellido())
                .addValue("ciudad", destinatario.getCiudad().toString())
                .addValue("direccion", destinatario.getDireccion());
    }

    @Override
    public Long crear(Destinatario destinatario) {
        SqlParameterSource parameterSource = this.obtenerParametrosDestinatario(destinatario);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public Destinatario optenerPorCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlObtenerPorCedula, parameterSource, new MapeoEntidadDestinatario());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }

    @Override
    public void actualizar(Destinatario destinatario) {
        SqlParameterSource parameterSource = this.obtenerParametrosDestinatario(destinatario);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActaulizar);
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }


}
