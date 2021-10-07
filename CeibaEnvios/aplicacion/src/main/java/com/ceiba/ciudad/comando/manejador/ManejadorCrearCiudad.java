package com.ceiba.ciudad.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ciudad.comando.ComandoCiudad;
import com.ceiba.ciudad.comando.fabricar.FabricarCiudad;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.servicio.ServicioCrearCiudad;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCiudad implements ManejadorComandoRespuesta<ComandoCiudad, ComandoRespuesta<Long>> {

    private final FabricarCiudad fabricarCiudad;
    private final ServicioCrearCiudad servicioCrearCiudad;

    public ManejadorCrearCiudad(FabricarCiudad fabricarCiudad, ServicioCrearCiudad servicioCrearCiudad) {
        this.fabricarCiudad = fabricarCiudad;
        this.servicioCrearCiudad = servicioCrearCiudad;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCiudad comandoCiudad){
        Ciudad ciudad = this.fabricarCiudad.crear(comandoCiudad);
        return new ComandoRespuesta<>(this.servicioCrearCiudad.ejecutar(ciudad));
    }
}
