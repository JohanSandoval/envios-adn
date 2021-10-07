package com.ceiba.dias_espera.comando.fabricar;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.dias_espera.comando.ComandoDiasEspera;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import org.springframework.stereotype.Component;

@Component
public class FabricarDiasEspera {

    public DiasEspera crear(ComandoDiasEspera comandoDiasEspera, RepositorioCiudad repositorioCiudad){
        Ciudad ciudadOrigen = repositorioCiudad.optenerPorId(comandoDiasEspera.getIdCiudadO());
        Ciudad ciudadDestino = repositorioCiudad.optenerPorId(comandoDiasEspera.getIdCiudadD());


        return new DiasEspera(
                comandoDiasEspera.getId(),
                ciudadOrigen,
                ciudadDestino,
                comandoDiasEspera.getDias()
        );
    }
}
