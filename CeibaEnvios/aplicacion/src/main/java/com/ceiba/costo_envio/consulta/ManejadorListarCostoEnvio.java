package com.ceiba.costo_envio.consulta;

import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;
import com.ceiba.costo_envio.puerto.dao.DaoCostoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCostoEnvio {

    private final DaoCostoEnvio daoCostoEnvio;

    public ManejadorListarCostoEnvio(DaoCostoEnvio daoCostoEnvio) {
        this.daoCostoEnvio = daoCostoEnvio;
    }

    public List<DtoCostoEnvio> ejecutar(){
        return this.daoCostoEnvio.listar();
    }
}
