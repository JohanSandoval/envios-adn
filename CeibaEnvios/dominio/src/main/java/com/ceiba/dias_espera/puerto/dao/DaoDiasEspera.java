package com.ceiba.dias_espera.puerto.dao;

import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;

import java.util.List;

public interface DaoDiasEspera {

    List<DtoDiasEspera> listar();

    List<DtoDiasEspera> listarById(Long id);
}
