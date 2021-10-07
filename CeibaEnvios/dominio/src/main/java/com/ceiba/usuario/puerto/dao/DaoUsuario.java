package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    List<DtoUsuario> listar();

    List<DtoUsuario> listarByCedula(String cedula);
}
