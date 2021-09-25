package com.ceiba.remitente.comando.fabrica;

import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.modelo.entidad.Remitente;
import org.springframework.stereotype.Component;

@Component
public class FabricarRemitente {

    public Remitente crear(ComandoRemitente comandoRemitente){
        return new Remitente(
                comandoRemitente.getId(),
                comandoRemitente.getCedula(),
                comandoRemitente.getNombre(),
                comandoRemitente.getApellido(),
                comandoRemitente.getCiudad(),
                comandoRemitente.getTelefono());
    }
}
