package com.ceiba.costo_envio.comando.fabricar;

import com.ceiba.costo_envio.comando.ComandoCostoEnvio;
import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import org.springframework.stereotype.Component;

@Component
public class FabricarCostoEnvio {

    public CostoEnvio crear(ComandoCostoEnvio comandoCostoEnvio){

        return new CostoEnvio(
                comandoCostoEnvio.getId(),
                comandoCostoEnvio.getPesoMin(),
                comandoCostoEnvio.getPesoMax(),
                comandoCostoEnvio.getCosto()
        );
    }
}
