package com.ceiba.remitente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;

public class ServicioCrearRemitente {

    private static final String EL_REMITENTE_YA_ESTA_REGISTRADO = "El remitente ya esta registrado en el sistema";

    private final RepositorioRemitente repositorioRemitente;

    public ServicioCrearRemitente(RepositorioRemitente repositorioRemitente) {
        this.repositorioRemitente = repositorioRemitente;
    }

    public Long ejecutar(Remitente remitente){
        validarExistenciaPrevia(remitente);
        return this.repositorioRemitente.crear(remitente);
    }

    public void validarExistenciaPrevia(Remitente remitente){
        boolean existe = this.repositorioRemitente.existe(remitente.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REMITENTE_YA_ESTA_REGISTRADO);
        }
    }
}
