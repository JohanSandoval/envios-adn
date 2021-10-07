package com.ceiba.usuario.comando.fabrica;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricarUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario, RepositorioCiudad repositorioCiudad){

        Ciudad ciudad = repositorioCiudad.optenerPorId(comandoUsuario.getCiudad());

        return  new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getCedula(),
                comandoUsuario.getNombre(),
                comandoUsuario.getApellido(),
                ciudad,
                comandoUsuario.getTelefono()
        );
    }
}
