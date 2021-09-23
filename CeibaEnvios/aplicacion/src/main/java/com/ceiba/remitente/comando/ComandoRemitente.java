package com.ceiba.remitente.comando;

import com.ceiba.enumeraciones.Ciudad;
import lombok.Data;

@Data
public class ComandoRemitente {

    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;
}
