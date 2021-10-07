package com.ceiba.costo_envio.puerto.repositorio;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;

public interface RepositorioCostoEnvio {

    Long crear(CostoEnvio costoEnvio);

    void actualizar (CostoEnvio costoEnvio);

    boolean existe(Double pesoMin, Double pesoMax);

    boolean existeExcluyendoId(Long id, Double pesoMin, Double pesoMax);

    CostoEnvio optenerPorPeso(Double peso);
}
