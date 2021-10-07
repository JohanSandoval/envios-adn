package com.ceiba.dias_espera.servicio;

import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioActualizarDiasEspera {

    private static final String RUTA_YA_REGISTRADA = "La ruta ya se encuentra registrada en el sistema";
    private final RepositorioDiasEspera repositorioDiasEspera;

    public ServicioActualizarDiasEspera(RepositorioDiasEspera repositorioDiasEspera) {
        this.repositorioDiasEspera = repositorioDiasEspera;
    }

    public void ejecutar(DiasEspera diasEspera){
        validarExistenciaPrevia(diasEspera);
        this.repositorioDiasEspera.actualizar(diasEspera);
    }

    public void validarExistenciaPrevia(DiasEspera diasEspera){
        boolean existe = this.repositorioDiasEspera.existeExcluyendoId(diasEspera.getId(),
                diasEspera.getCiudadOrigen().getId(), diasEspera.getCiudadDestino().getId());
        if (existe){
            throw  new ExcepcionDuplicidad(RUTA_YA_REGISTRADA);
        }
    }
}

