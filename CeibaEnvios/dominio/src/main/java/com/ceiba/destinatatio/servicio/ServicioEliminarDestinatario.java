package com.ceiba.destinatatio.servicio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;

public class ServicioEliminarDestinatario {

    private static final String EL_DESTINATARIO_NO_ESTA_REGISTRADO = "El destinatario no esta registrado en el sistema";

    private final RepositorioDestinatario repositorioDestinatario;

    public ServicioEliminarDestinatario(RepositorioDestinatario repositorioDestinatario) {
        this.repositorioDestinatario = repositorioDestinatario;
    }

    public void ejecutar(Destinatario destinatario){
        validarExistenciaPrevia(destinatario);
        this.repositorioDestinatario.eliminar(destinatario.getId());
    }

    public void validarExistenciaPrevia(Destinatario destinatario){
        boolean existe = this.repositorioDestinatario.existe(destinatario.getNombre());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_DESTINATARIO_NO_ESTA_REGISTRADO);
        }
    }
}
