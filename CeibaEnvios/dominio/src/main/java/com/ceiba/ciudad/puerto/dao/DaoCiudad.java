package com.ceiba.ciudad.puerto.dao;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;

import java.util.List;

public interface DaoCiudad {

    List<DtoCiudad> listar();

    List<DtoCiudad> listarById(Long id);
}
