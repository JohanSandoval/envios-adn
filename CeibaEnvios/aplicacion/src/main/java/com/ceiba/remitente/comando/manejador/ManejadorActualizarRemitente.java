package com.ceiba.remitente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.comando.fabrica.FabricarRemitente;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.servicio.ServicioActualizarRemitente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRemitente implements ManejadorComando<ComandoRemitente> {

    private final FabricarRemitente fabricarRemitente;
    private final ServicioActualizarRemitente servicioActualizarRemitente;

    public ManejadorActualizarRemitente(FabricarRemitente fabricarRemitente, ServicioActualizarRemitente servicioActualizarRemitente) {
        this.fabricarRemitente = fabricarRemitente;
        this.servicioActualizarRemitente = servicioActualizarRemitente;
    }

    @Override
    public void ejecutar(ComandoRemitente comandoRemitente) {
        Remitente remitente = this.fabricarRemitente.crear(comandoRemitente);
        this.servicioActualizarRemitente.ejecutar(remitente);
    }
}
