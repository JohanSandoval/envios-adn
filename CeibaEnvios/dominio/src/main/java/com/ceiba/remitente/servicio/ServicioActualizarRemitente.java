package com.ceiba.remitente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;

public class ServicioActualizarRemitente {

    private static final String EL_REMITENTE_NO_ESTA_REGISTRADO = "El remitente no esta registrado en el sistema";

    private final RepositorioRemitente repositorioRemitente;

    public ServicioActualizarRemitente(RepositorioRemitente repositorioRemitente) {
        this.repositorioRemitente = repositorioRemitente;
    }

    public void ejecutar(Remitente remitente){
        validarExistenciaPrevia(remitente);
        this.repositorioRemitente.actualizar(remitente);
    }

    public void validarExistenciaPrevia(Remitente remitente){
        boolean existe = this.repositorioRemitente.existe(remitente.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REMITENTE_NO_ESTA_REGISTRADO);
        }
    }
}
