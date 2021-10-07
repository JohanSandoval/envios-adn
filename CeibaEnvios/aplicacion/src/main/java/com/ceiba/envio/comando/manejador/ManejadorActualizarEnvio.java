package com.ceiba.envio.comando.manejador;


import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.comando.fabrica.FabricarEnvio;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.servicio.ServicioActualizarEnvio;
import com.ceiba.manejador.ManejadorComando;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEnvio implements ManejadorComando<ComandoEnvio> {

    private final FabricarEnvio fabricarEnvio;
    private final ServicioActualizarEnvio servicioActualizarEnvio;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioCostoEnvio repositorioCostoEnvio;
    private final RepositorioDiasEspera repositorioDiasEspera;

    public ManejadorActualizarEnvio(FabricarEnvio fabricarEnvio, ServicioActualizarEnvio servicioActualizarEnvio, RepositorioUsuario repositorioUsuario, RepositorioCostoEnvio repositorioCostoEnvio,
                                    RepositorioDiasEspera repositorioDiasEspera) {
        this.fabricarEnvio = fabricarEnvio;
        this.servicioActualizarEnvio= servicioActualizarEnvio;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCostoEnvio = repositorioCostoEnvio;
        this.repositorioDiasEspera = repositorioDiasEspera;
    }

    @Override
    public void ejecutar(ComandoEnvio comandoEnvio) {
        Envio envio = this.fabricarEnvio.crear(comandoEnvio, this.repositorioUsuario, this.repositorioCostoEnvio,this.repositorioDiasEspera);
        this.servicioActualizarEnvio.ejecutar(envio);
    }
}
