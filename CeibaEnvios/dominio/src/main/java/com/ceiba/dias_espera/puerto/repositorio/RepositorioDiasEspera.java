package com.ceiba.dias_espera.puerto.repositorio;

import com.ceiba.dias_espera.modelo.entidad.DiasEspera;

public interface RepositorioDiasEspera {

    Long crear(DiasEspera diasEspera);

    void actualizar(DiasEspera diasEspera);

    boolean existe(Long ciudadO, Long ciudadD);

    boolean existeExcluyendoId(Long id, Long ciudadO, Long ciudadD);

    DiasEspera optenerPorId(Long idCiudadO, Long idCiudadD);
}
