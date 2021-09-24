package com.ceiba.remitente.puerto.dao;

import com.ceiba.remitente.modelo.dto.DtoRemitente;

import java.util.List;

public interface DaoRemitente {

    List<DtoRemitente> listar();

    List<DtoRemitente> listarById(Long id);

}
