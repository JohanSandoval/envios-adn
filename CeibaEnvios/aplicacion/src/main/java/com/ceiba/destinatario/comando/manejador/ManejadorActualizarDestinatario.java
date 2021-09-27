package com.ceiba.destinatario.comando.manejador;

import com.ceiba.destinatario.comando.ComandoDestinatario;
import com.ceiba.destinatario.comando.fabrica.FabricarDestinatario;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.servicio.ServicioActualizarDestinatario;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDestinatario implements ManejadorComando<ComandoDestinatario> {

    private final FabricarDestinatario fabricarDestinatario;
    private final ServicioActualizarDestinatario servicioActualizarDestinatario;

    public ManejadorActualizarDestinatario(FabricarDestinatario fabricarDestinatario, ServicioActualizarDestinatario servicioActualizarDestinatario) {
        this.fabricarDestinatario = fabricarDestinatario;
        this.servicioActualizarDestinatario = servicioActualizarDestinatario;
    }

    @Override
    public void ejecutar(ComandoDestinatario comando) {
        Destinatario destinatario = this.fabricarDestinatario.crear(comando);
        System.out.println(destinatario.toString());
        this.servicioActualizarDestinatario.ejecutar(destinatario);
    }
}
