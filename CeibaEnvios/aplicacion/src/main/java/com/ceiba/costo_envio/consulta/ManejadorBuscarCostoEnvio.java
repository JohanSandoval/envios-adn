package com.ceiba.costo_envio.consulta;

import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;
import com.ceiba.costo_envio.puerto.dao.DaoCostoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarCostoEnvio {

    private final DaoCostoEnvio daoCostoEnvio;

    public ManejadorBuscarCostoEnvio(DaoCostoEnvio daoCostoEnvio) {
        this.daoCostoEnvio = daoCostoEnvio;
    }

    public List<DtoCostoEnvio> ejecutar(Long id){
        return daoCostoEnvio.listarById(id);
    }
}
