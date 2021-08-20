package com.ceiba.envio.puerto.repositorio;

import com.ceiba.envio.modelo.entidad.Envio;

public interface RepositorioEnvio {
     /**
     * Permite crear un envio
     * @param envio
     * @return el id generado
     */
    Long crear(Envio envio);

    /**
     * Permite actualizar un envio
     * @param envio
     */
    void actualizar(Envio envio);

    /**
     * Permite eliminar un envio
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un envio con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(Envio nombre);

    /**
     * Permite validar si existe un envio con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String nombre);
}
