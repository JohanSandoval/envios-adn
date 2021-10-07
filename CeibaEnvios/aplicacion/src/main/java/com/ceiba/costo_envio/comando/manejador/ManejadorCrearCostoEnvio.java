package com.ceiba.costo_envio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.costo_envio.comando.ComandoCostoEnvio;
import com.ceiba.costo_envio.comando.fabricar.FabricarCostoEnvio;
import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioCrearCostoEnvio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCostoEnvio implements ManejadorComandoRespuesta<ComandoCostoEnvio, ComandoRespuesta<Long>> {

    private final FabricarCostoEnvio fabricarCostoEnvio;
    private final ServicioCrearCostoEnvio servicioCrearCostoEnvio;
    private final RepositorioCostoEnvio repositorioCostoEnvio;

    public ManejadorCrearCostoEnvio(FabricarCostoEnvio fabricarCostoEnvio,
                                    ServicioCrearCostoEnvio servicioCrearCostoEnvio,
                                    RepositorioCostoEnvio repositorioCostoEnvio) {
        this.fabricarCostoEnvio = fabricarCostoEnvio;
        this.servicioCrearCostoEnvio = servicioCrearCostoEnvio;
        this.repositorioCostoEnvio = repositorioCostoEnvio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCostoEnvio comando) {
        CostoEnvio costoEnvio = this.fabricarCostoEnvio.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearCostoEnvio.ejecutar(costoEnvio));
    }
}
