package com.ceiba.envio.consulta;

import com.ceiba.envio.modelo.dto.DtoEnvio;
import com.ceiba.envio.puerto.dao.DaoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarEnvio {

    private final DaoEnvio daoEnvio;

    public ManejadorBuscarEnvio(DaoEnvio daoEnvio) {
        this.daoEnvio = daoEnvio;
    }

    public List<DtoEnvio> ejecutar(Long id){
        return daoEnvio.listarById(id);
    }
}
