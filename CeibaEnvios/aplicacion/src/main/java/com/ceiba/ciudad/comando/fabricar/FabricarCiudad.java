package com.ceiba.ciudad.comando.fabricar;

import com.ceiba.ciudad.comando.ComandoCiudad;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import org.springframework.stereotype.Component;

@Component
public class FabricarCiudad {

    public Ciudad crear(ComandoCiudad comandoCiudad){
        return new Ciudad(
                comandoCiudad.getId(),
                comandoCiudad.getNombre()
        );
    }
}
