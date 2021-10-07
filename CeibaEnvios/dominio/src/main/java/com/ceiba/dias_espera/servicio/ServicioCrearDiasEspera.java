package com.ceiba.dias_espera.servicio;

import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearDiasEspera {

    private static final String RUTA_YA_ASIGNADA = "la ruta ya esta definida en el sistema";
    private final RepositorioDiasEspera repositorioDiasEspera;

    public ServicioCrearDiasEspera(RepositorioDiasEspera repositorioDiasEspera) {
        this.repositorioDiasEspera = repositorioDiasEspera;
    }

    public Long ejecutar(DiasEspera diasEspera){
        validarExistenciaPrevia(diasEspera);
        return this.repositorioDiasEspera.crear(diasEspera);
    }

    public void validarExistenciaPrevia(DiasEspera diasEspera){
        boolean existe = this.repositorioDiasEspera.existe(diasEspera.getCiudadOrigen().getId(),
                diasEspera.getCiudadDestino().getId());
        if (existe){
            throw  new ExcepcionDuplicidad(RUTA_YA_ASIGNADA);
        }
    }
}
