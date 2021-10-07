package com.ceiba.dias_espera.comando.manejador;

import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.dias_espera.comando.ComandoDiasEspera;
import com.ceiba.dias_espera.comando.fabricar.FabricarDiasEspera;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.servicio.ServicioActualizarDiasEspera;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDiasEspera implements ManejadorComando<ComandoDiasEspera> {

    private final FabricarDiasEspera fabricarDiasEspera;
    private final ServicioActualizarDiasEspera servicioActualizarDiasEspera;
    private final RepositorioCiudad repositorioCiudad;

    public ManejadorActualizarDiasEspera(FabricarDiasEspera fabricarDiasEspera,
                                         ServicioActualizarDiasEspera servicioActualizarDiasEspera,
                                         RepositorioCiudad repositorioCiudad) {
        this.fabricarDiasEspera = fabricarDiasEspera;
        this.servicioActualizarDiasEspera = servicioActualizarDiasEspera;
        this.repositorioCiudad = repositorioCiudad;
    }

    @Override
    public void ejecutar(ComandoDiasEspera comandoDiasEspera) {
        DiasEspera diasEspera = this.fabricarDiasEspera.crear(comandoDiasEspera, this.repositorioCiudad);
        this.servicioActualizarDiasEspera.ejecutar(diasEspera);
    }
}
