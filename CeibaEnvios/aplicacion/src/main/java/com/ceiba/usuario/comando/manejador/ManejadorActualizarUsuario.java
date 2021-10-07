package com.ceiba.usuario.comando.manejador;

import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricarUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoUsuario> {

    private final FabricarUsuario fabricarUsuario;
    private final ServicioActualizarUsuario servicioActualizarUsuario;
    private final RepositorioCiudad repositorioCiudad;

    public ManejadorActualizarUsuario(FabricarUsuario fabricarUsuario,
                                      ServicioActualizarUsuario servicioActualizarUsuario, RepositorioCiudad repositorioCiudad) {
        this.fabricarUsuario = fabricarUsuario;
        this.servicioActualizarUsuario = servicioActualizarUsuario;
        this.repositorioCiudad = repositorioCiudad;
    }

    @Override
    public void ejecutar(ComandoUsuario comandoUsuario){
        Usuario usuario = this.fabricarUsuario.crear(comandoUsuario, this.repositorioCiudad);
        this.servicioActualizarUsuario.ejecutar(usuario);
    }
}
