package com.ceiba.remitente.puerto.repositorio;

import com.ceiba.remitente.modelo.entidad.Remitente;

public interface RepositorioRemitente {

    Long crear(Remitente remitente);

    void actualizar(Remitente remitente);

    void eliminar(Long id);

    boolean existe(String id);

    Remitente optenerPorCedula(String cedula);
}
