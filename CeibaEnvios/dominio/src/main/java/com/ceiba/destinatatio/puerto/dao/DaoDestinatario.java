package com.ceiba.destinatatio.puerto.dao;

import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;

import java.util.List;

public interface DaoDestinatario {

    List<DtoDestinatario> listar();

    List<DtoDestinatario> listarById(String cedula);
}
