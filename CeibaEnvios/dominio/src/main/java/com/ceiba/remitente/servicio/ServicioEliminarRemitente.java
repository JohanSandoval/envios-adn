package com.ceiba.remitente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;

public class ServicioEliminarRemitente {

    private final RepositorioRemitente repositorioRemitente;

    private static final String EL_REMITENTE_NO_ESTA_REGISTRADO = "El remitente no esta registrado en el sistema";

    public ServicioEliminarRemitente(RepositorioRemitente repositorioRemitente) {
        this.repositorioRemitente = repositorioRemitente;
    }

    public void ejecutar(Remitente remitente){
        validarExistenciaPrevia(remitente);
        this.repositorioRemitente.eliminar(remitente.getId());
    }

    public void validarExistenciaPrevia(Remitente remitente){
        boolean existe = this.repositorioRemitente.existe(remitente.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REMITENTE_NO_ESTA_REGISTRADO);
        }
    }

}
