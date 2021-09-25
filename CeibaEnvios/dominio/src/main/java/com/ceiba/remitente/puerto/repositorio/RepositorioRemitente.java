package com.ceiba.remitente.puerto.repositorio;

import com.ceiba.remitente.modelo.entidad.Remitente;

public interface RepositorioRemitente {

    Long crear(Remitente remitente);

    void actualizar(Remitente remitente);

    boolean existe(String cedula);

    boolean existeExcluyendoId(Long id, String cedula);

    Remitente optenerPorCedula(String cedula);
}
