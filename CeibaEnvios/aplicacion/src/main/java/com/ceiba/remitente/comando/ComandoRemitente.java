package com.ceiba.remitente.comando;

import lombok.Data;

@Data
public class ComandoRemitente {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;
}
