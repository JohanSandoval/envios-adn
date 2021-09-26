package com.ceiba.destinatatio.puerto.repositorio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;

public interface RepositorioDestinatario {

    Long crear(Destinatario destinatario);

    void actualizar(Destinatario destinatario);

    boolean existe(String cedula);

    boolean existeExcluyendoId(Long id, String cedula);

    Destinatario optenerPorCedula(String cedula);
}
