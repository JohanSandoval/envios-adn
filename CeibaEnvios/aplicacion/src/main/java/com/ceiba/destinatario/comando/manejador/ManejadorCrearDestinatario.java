package com.ceiba.destinatario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.destinatario.comando.ComandoDestinatario;

import com.ceiba.destinatario.comando.fabrica.FabricarDestinatario;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.servicio.ServicioCrearDestinatario;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDestinatario implements ManejadorComandoRespuesta<ComandoDestinatario, ComandoRespuesta<Long>> {

    private final FabricarDestinatario fabricarDestinatario;
    private final ServicioCrearDestinatario  servicioCrearDestinatario;

    public ManejadorCrearDestinatario(FabricarDestinatario fabricarDestinatario, ServicioCrearDestinatario servicioCrearDestinatario) {
        this.fabricarDestinatario = fabricarDestinatario;
        this.servicioCrearDestinatario = servicioCrearDestinatario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDestinatario comandoDestinatario){
        Destinatario destinatario = this.fabricarDestinatario.crear(comandoDestinatario);
        return new ComandoRespuesta<>(this.servicioCrearDestinatario.ejecutar(destinatario));
    }
}
