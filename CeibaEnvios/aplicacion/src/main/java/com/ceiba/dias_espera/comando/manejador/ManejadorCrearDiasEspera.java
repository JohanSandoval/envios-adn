package com.ceiba.dias_espera.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.dias_espera.comando.ComandoDiasEspera;
import com.ceiba.dias_espera.comando.fabricar.FabricarDiasEspera;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.servicio.ServicioCrearDiasEspera;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDiasEspera implements ManejadorComandoRespuesta<ComandoDiasEspera, ComandoRespuesta<Long>> {

    private final FabricarDiasEspera fabricarDiasEspera;
    private final ServicioCrearDiasEspera servicioCrearDiasEspera;
    private final RepositorioCiudad repositorioCiudad;

    public ManejadorCrearDiasEspera(FabricarDiasEspera fabricarDiasEspera,
                                    ServicioCrearDiasEspera servicioCrearDiasEspera,
                                    RepositorioCiudad repositorioCiudad) {
        this.fabricarDiasEspera = fabricarDiasEspera;
        this.servicioCrearDiasEspera = servicioCrearDiasEspera;
        this.repositorioCiudad = repositorioCiudad;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoDiasEspera comandoDiasEspera) {
        DiasEspera diasEspera = this.fabricarDiasEspera.crear(comandoDiasEspera, repositorioCiudad);
        return new ComandoRespuesta<>(this.servicioCrearDiasEspera.ejecutar(diasEspera));
    }
}
