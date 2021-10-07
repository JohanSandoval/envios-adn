package com.ceiba.costo_envio.comando.manejador;

import com.ceiba.costo_envio.comando.ComandoCostoEnvio;
import com.ceiba.costo_envio.comando.fabricar.FabricarCostoEnvio;
import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioActualizarCostoEnvio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCostoEnvio implements ManejadorComando<ComandoCostoEnvio> {

    private final FabricarCostoEnvio fabricarCostoEnvio;
    private final ServicioActualizarCostoEnvio servicioActualizarCostoEnvio;
    private final RepositorioCostoEnvio repositorioCostoEnvio;

    public ManejadorActualizarCostoEnvio(FabricarCostoEnvio fabricarCostoEnvio,
                                         ServicioActualizarCostoEnvio servicioActualizarCostoEnvio,
                                         RepositorioCostoEnvio repositorioCostoEnvio) {
        this.fabricarCostoEnvio = fabricarCostoEnvio;
        this.servicioActualizarCostoEnvio = servicioActualizarCostoEnvio;
        this.repositorioCostoEnvio = repositorioCostoEnvio;
    }

    @Override
    public void ejecutar(ComandoCostoEnvio comandoCostoEnvio){
        CostoEnvio costoEnvio = this.fabricarCostoEnvio.crear(comandoCostoEnvio);
        this.servicioActualizarCostoEnvio.ejecutar(costoEnvio);
    }
}
