package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricarUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricarUsuario fabricarUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;
    private final RepositorioCiudad repositorioCiudad;

    public ManejadorCrearUsuario(FabricarUsuario fabricarUsuario, ServicioCrearUsuario servicioCrearUsuario,
                                 RepositorioCiudad repositorioCiudad) {
        this.fabricarUsuario = fabricarUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.repositorioCiudad = repositorioCiudad;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario){
        Usuario usuario = this.fabricarUsuario.crear(comandoUsuario, repositorioCiudad);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}
