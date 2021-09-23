package com.ceiba.destinatario.consulta;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.destinatatio.puerto.dao.DaoDestinatario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDestinatario {

    private final DaoDestinatario daoDestinatario;

    public ManejadorListarDestinatario(DaoDestinatario daoDestinatario) {
        this.daoDestinatario = daoDestinatario;
    }

    public List<DtoDestinatario> ejecutar(){
        return this.daoDestinatario.listar();
    }
}
