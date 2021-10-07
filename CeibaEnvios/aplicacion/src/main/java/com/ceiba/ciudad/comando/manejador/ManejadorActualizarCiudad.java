package com.ceiba.ciudad.comando.manejador;

import com.ceiba.ciudad.comando.ComandoCiudad;
import com.ceiba.ciudad.comando.fabricar.FabricarCiudad;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.servicio.ServicioActualizarCiudad;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCiudad implements ManejadorComando<ComandoCiudad> {

    private final FabricarCiudad fabricarCiudad;
    private final ServicioActualizarCiudad servicioActualizarCiudad;

    public ManejadorActualizarCiudad(FabricarCiudad fabricarCiudad,
                                     ServicioActualizarCiudad servicioActualizarCiudad) {
        this.fabricarCiudad = fabricarCiudad;
        this.servicioActualizarCiudad = servicioActualizarCiudad;
    }

    @Override
    public void ejecutar(ComandoCiudad comando) {
        Ciudad ciudad = this.fabricarCiudad.crear(comando);
        this.servicioActualizarCiudad.ejecutar(ciudad);
    }
}
