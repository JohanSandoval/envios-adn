package com.ceiba.envio.puerto.repositorio;

import com.ceiba.envio.modelo.entidad.Envio;

public interface RepositorioEnvio {

    Long crear(Envio envio);

    void actualizar(Envio envio);

    void eliminar(Long id);

    boolean existe(Envio nombre);

    boolean existeExcluyendoId(Long id, String nombre);
}
