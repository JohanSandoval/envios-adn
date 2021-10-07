package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarUsuario {

    private final DaoUsuario daoUsuario;

    public ManejadorBuscarUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(String cedula){
        return daoUsuario.listarByCedula(cedula);
    }
}
