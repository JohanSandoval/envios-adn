package com.ceiba.destinatario.comando.fabrica;

import com.ceiba.destinatario.comando.ComandoDestinatario;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import org.springframework.stereotype.Component;

@Component
public class FabricarDestinatario {

    public Destinatario crear(ComandoDestinatario comandoDestinatario){
        return new Destinatario(
                comandoDestinatario.getId(),
                comandoDestinatario.getCedula(),
                comandoDestinatario.getNombre(),
                comandoDestinatario.getApellido(),
                comandoDestinatario.getCiudad(),
                comandoDestinatario.getDireccion()
        );
    }
}
