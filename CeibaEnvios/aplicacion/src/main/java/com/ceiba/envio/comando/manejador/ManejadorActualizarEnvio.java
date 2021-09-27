package com.ceiba.envio.comando.manejador;

import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.comando.fabrica.FabricarEnvio;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.servicio.ServicioActualizarEnvio;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEnvio implements ManejadorComando<ComandoEnvio> {

    private final FabricarEnvio fabricarEnvio;
    private final ServicioActualizarEnvio servicioActualizarEnvio;
    private final RepositorioRemitente repositorioRemitente;
    private final RepositorioDestinatario repositorioDestinatario;

    public ManejadorActualizarEnvio(FabricarEnvio fabricarEnvio, ServicioActualizarEnvio servicioActualizarEnvio,
                                    RepositorioRemitente repositorioRemitente, RepositorioDestinatario repositorioDestinatario) {
        this.fabricarEnvio = fabricarEnvio;
        this.servicioActualizarEnvio = servicioActualizarEnvio;
        this.repositorioRemitente = repositorioRemitente;
        this.repositorioDestinatario = repositorioDestinatario;
    }

    @Override
    public void ejecutar(ComandoEnvio comandoEnvio) {
        Envio envio = this.fabricarEnvio.crear(comandoEnvio, this.repositorioRemitente, this.repositorioDestinatario);
        this.servicioActualizarEnvio.ejecutar(envio);
    }
}
