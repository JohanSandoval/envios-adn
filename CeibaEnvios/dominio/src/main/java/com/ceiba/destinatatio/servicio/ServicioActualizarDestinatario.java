package com.ceiba.destinatatio.servicio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDestinatario {

    private static final String EL_DESTINATARIO_NO_ESTA_REGISTRADO = "El destinatario no esta registrado en el sistema";

    private final RepositorioDestinatario repositorioDestinatario;

    public ServicioActualizarDestinatario(RepositorioDestinatario repositorioDestinatario) {
        this.repositorioDestinatario = repositorioDestinatario;
    }

    public void ejecutar(Destinatario destinatario){
        validarExistenciaPrevia(destinatario);
        this.repositorioDestinatario.actualizar(destinatario);
    }

    public void validarExistenciaPrevia(Destinatario destinatario){
        boolean existe = this.repositorioDestinatario.existe(destinatario.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_DESTINATARIO_NO_ESTA_REGISTRADO);
        }
    }
}
