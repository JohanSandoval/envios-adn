package com.ceiba.remitente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.comando.fabrica.FabricarRemitente;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.servicio.ServicioCrearRemitente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRemitente implements ManejadorComandoRespuesta<ComandoRemitente, ComandoRespuesta<Long>> {

    private final FabricarRemitente fabricarRemitente;
    private final ServicioCrearRemitente servicioCrearRemitente;

    public ManejadorCrearRemitente(FabricarRemitente fabricarRemitente, ServicioCrearRemitente servicioCrearRemitente) {
        this.fabricarRemitente = fabricarRemitente;
        this.servicioCrearRemitente = servicioCrearRemitente;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRemitente comandoRemitente){
        Remitente remitente = this.fabricarRemitente.crear(comandoRemitente);
        return new ComandoRespuesta<>(this.servicioCrearRemitente.ejecutar(remitente));
    }
}
