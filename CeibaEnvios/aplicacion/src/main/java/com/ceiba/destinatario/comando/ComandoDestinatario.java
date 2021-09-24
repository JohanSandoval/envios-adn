package com.ceiba.destinatario.comando;

import lombok.Data;

@Data
public class ComandoDestinatario {

    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;
}
