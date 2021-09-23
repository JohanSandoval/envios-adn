package com.ceiba.destinatatio.servicio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;

public class ServicioCrearDestinatario {

    private static final String EL_DESTINATARIO_YA_ESTA_REGISTRADO = "El destinatario ya esta registrado en el sistema";

    private final RepositorioDestinatario repositorioDestinatario;

    public ServicioCrearDestinatario(RepositorioDestinatario repositorioDestinatario) {
        this.repositorioDestinatario = repositorioDestinatario;
    }

    public Long ejecutar(Destinatario destinatario){
        validarExistenciaPrevia(destinatario);
        return this.repositorioDestinatario.crear(destinatario);
    }

    public void validarExistenciaPrevia(Destinatario destinatario){
        boolean existe = this.repositorioDestinatario.existe(destinatario.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_DESTINATARIO_YA_ESTA_REGISTRADO);
        }
    }

}
