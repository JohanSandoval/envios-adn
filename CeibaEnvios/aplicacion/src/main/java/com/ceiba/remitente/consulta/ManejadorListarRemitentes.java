package com.ceiba.remitente.consulta;

import com.ceiba.remitente.modelo.dto.DtoRemitente;
import com.ceiba.remitente.puerto.dao.DaoRemitente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRemitentes {

    private  final DaoRemitente daoRemitente;

    public ManejadorListarRemitentes(DaoRemitente daoRemitente) {
        this.daoRemitente = daoRemitente;
    }

    public List<DtoRemitente> ejecutar(){return this.daoRemitente.listar();}
}
