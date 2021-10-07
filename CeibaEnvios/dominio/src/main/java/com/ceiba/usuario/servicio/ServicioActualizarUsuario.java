package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_NO_ESTA_REGISTRADA = "El usuario no esta registrado en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario){
        validarExistenciaPrevia(usuario);
        repositorioUsuario.actualizar(usuario);
    }

    public void validarExistenciaPrevia(Usuario usuario){
        boolean existe = this.repositorioUsuario.existeExcluyendoId(usuario.getId(), usuario.getCedula());
        if (existe){
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_ESTA_REGISTRADA);
        }
    }
}
