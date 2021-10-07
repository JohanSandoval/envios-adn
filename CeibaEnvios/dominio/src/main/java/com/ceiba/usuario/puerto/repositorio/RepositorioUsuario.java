package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {

    long crear(Usuario usuario);

    void actualizar(Usuario usuario);

    boolean existe(String cedula);

    boolean existeExcluyendoId(Long id, String cedula);

    Usuario optenerPorCedula(String cedula);

}
