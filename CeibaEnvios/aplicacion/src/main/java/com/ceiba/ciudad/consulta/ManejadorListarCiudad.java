package com.ceiba.ciudad.consulta;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCiudad {

    private final DaoCiudad daoCiudad;

    public ManejadorListarCiudad(DaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }

    public List<DtoCiudad> ejecutar(){
        return this.daoCiudad.listar();
    }
}
