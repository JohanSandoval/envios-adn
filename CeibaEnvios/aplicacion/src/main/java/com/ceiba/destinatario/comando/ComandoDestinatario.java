package com.ceiba.destinatario.comando;

import com.ceiba.enumeraciones.Ciudad;
import lombok.Data;

@Data
public class ComandoDestinatario {

    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String direccion;
}
