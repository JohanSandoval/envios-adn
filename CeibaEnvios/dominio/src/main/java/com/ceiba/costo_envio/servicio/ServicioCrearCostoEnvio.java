package com.ceiba.costo_envio.servicio;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCostoEnvio {

    private static final String COSTO_YA_CREADO = "Costo ya registrado";
    private final RepositorioCostoEnvio repositorioCostoEnvio;

    public ServicioCrearCostoEnvio(RepositorioCostoEnvio repositorioCostoEnvio) {
        this.repositorioCostoEnvio = repositorioCostoEnvio;
    }

    public Long ejecutar(CostoEnvio costoEnvio){
        validarExistenciaPrevia(costoEnvio);
        return this.repositorioCostoEnvio.crear(costoEnvio);
    }

    public void validarExistenciaPrevia(CostoEnvio costoEnvio){
        boolean existe = this.repositorioCostoEnvio.existe((costoEnvio.getPesoMin()),
                costoEnvio.getPesoMax());
        if(existe){
            throw new ExcepcionDuplicidad(COSTO_YA_CREADO);
        }
    }
}
