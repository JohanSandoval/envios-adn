package com.ceiba.costo_envio.servicio;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCostoEnvio {

    private static final String COSTO_YA_REGISTRADO = "El costo no ha sido encontrado";
    private final RepositorioCostoEnvio repositorioCostoEnvio;

    public ServicioActualizarCostoEnvio(RepositorioCostoEnvio repositorioCostoEnvio) {
        this.repositorioCostoEnvio = repositorioCostoEnvio;
    }

    public void ejecutar(CostoEnvio costoEnvio){
        validarExistenciaPrevia(costoEnvio);
        this.repositorioCostoEnvio.actualizar(costoEnvio);
    }

    public void validarExistenciaPrevia(CostoEnvio costoEnvio){
        boolean existe = this.repositorioCostoEnvio.existeExcluyendoId(costoEnvio.getId(),
                costoEnvio.getPesoMin(), costoEnvio.getPesoMax());
        if (existe){
            throw new ExcepcionDuplicidad(COSTO_YA_REGISTRADO);
        }
    }

}
