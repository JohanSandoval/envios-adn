package com.ceiba.dias_espera.consulta;

import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;
import com.ceiba.dias_espera.puerto.dao.DaoDiasEspera;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarDiasEspera {

    private final DaoDiasEspera daoDiasEspera;

    public ManejadorBuscarDiasEspera(DaoDiasEspera daoDiasEspera) {
        this.daoDiasEspera = daoDiasEspera;
    }

    public List<DtoDiasEspera> ejecutar(Long id){
        return daoDiasEspera.listarById(id);
    }
}
