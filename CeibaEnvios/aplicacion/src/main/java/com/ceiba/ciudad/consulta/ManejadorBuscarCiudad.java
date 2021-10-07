package com.ceiba.ciudad.consulta;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarCiudad {

    private final DaoCiudad daoCiudad;

    public ManejadorBuscarCiudad(DaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }

    public List<DtoCiudad> ejecutar(Long id){
        return daoCiudad.listarById(id);
    }
}
