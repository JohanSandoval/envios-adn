package com.ceiba.ciudad.puerto.repositorio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;

public interface RepositorioCiudad {

    Long crear(Ciudad ciudad);

    void actualizar(Ciudad ciudad);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id, String nombre);

    Ciudad optenerPorId(Long id);

}
