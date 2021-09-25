package com.ceiba.remitente.consulta;

import com.ceiba.remitente.modelo.dto.DtoRemitente;
import com.ceiba.remitente.puerto.dao.DaoRemitente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarRemitente {

    private final DaoRemitente daoRemitente;

    public ManejadorBuscarRemitente(DaoRemitente daoRemitente) {
        this.daoRemitente = daoRemitente;
    }

    public List<DtoRemitente> ejecutar(String cedula){
        return daoRemitente.listarByCedula(cedula);
    }
}
