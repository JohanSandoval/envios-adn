package com.ceiba.destinatario.consulta;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import com.ceiba.destinatatio.puerto.dao.DaoDestinatario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarDestinatario {

    private final DaoDestinatario daoDestinatario;

    public ManejadorBuscarDestinatario(DaoDestinatario daoDestinatario) {
        this.daoDestinatario = daoDestinatario;
    }

    public List<DtoDestinatario> ejecutar(Long id){
        return daoDestinatario.listarById(id);
    }
}
