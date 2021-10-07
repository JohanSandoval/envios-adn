package com.ceiba.dias_espera.consulta;

import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;
import com.ceiba.dias_espera.puerto.dao.DaoDiasEspera;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDiasEspera {

    private final DaoDiasEspera diasEspera;

    public ManejadorListarDiasEspera(DaoDiasEspera diasEspera) {
        this.diasEspera = diasEspera;
    }

    public List<DtoDiasEspera> ejecutar(){
        return  this.diasEspera.listar();
    }
}
