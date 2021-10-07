package com.ceiba.costo_envio.puerto.dao;

import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;

import java.util.List;

public interface DaoCostoEnvio {

    List<DtoCostoEnvio> listar();

    List<DtoCostoEnvio> listarById(Long id);


}
