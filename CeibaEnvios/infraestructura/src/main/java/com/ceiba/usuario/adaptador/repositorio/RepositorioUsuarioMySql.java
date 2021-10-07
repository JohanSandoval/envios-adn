package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioUsuarioMySql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado";
    private static final Logger LOGGER = Logger.getLogger(RepositorioUsuarioMySql.class.getName());

    @SqlStatement(namespace = "usuario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "usuario", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "usuario", value = "optenerPorCedula")
    private static String sqlOptenerPorCedula;

    @SqlStatement(namespace = "usuario", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "usuario", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioUsuarioMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosUsuario(Usuario usuario){
        return  new MapSqlParameterSource()
                .addValue("id", usuario.getId())
                .addValue("cedula", usuario.getCedula())
                .addValue("nombre", usuario.getNombre())
                .addValue("apellido", usuario.getApellido())
                .addValue("ciudad", usuario.getCiudad().getId())
                .addValue("telefono", usuario.getTelefono());
    }


    @Override
    public long crear(Usuario usuario) {
        SqlParameterSource parameterSource = this.obtenerParametrosUsuario(usuario);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void actualizar(Usuario usuario) {
        SqlParameterSource parameterSource = this.obtenerParametrosUsuario(usuario);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
    }

    @Override
    public boolean existe(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }

    @Override
    public Usuario optenerPorCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        try{
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlOptenerPorCedula, parameterSource, new MapeoEntidadUsuario());
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }
}
