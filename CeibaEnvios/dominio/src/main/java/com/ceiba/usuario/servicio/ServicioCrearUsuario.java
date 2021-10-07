package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_ESTA_REGISTRADO = "El usuario ya esta registrado en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario){
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);

    }

    public void validarExistenciaPrevia(Usuario usuario){
        boolean existe = this.repositorioUsuario.existe(usuario.getCedula());
        if (existe){
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_ESTA_REGISTRADO);
        }
    }
}
