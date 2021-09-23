package com.ceiba.destinatatio.puerto.repositorio;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;

public interface RepositorioDestinatario {

    Long crear(Destinatario destinatario);

    void actualizar(Destinatario destinatario);

    void eliminar(Long id);

    boolean existe(String nombre);

    Destinatario optenerPorCedula(String cedula);
}
