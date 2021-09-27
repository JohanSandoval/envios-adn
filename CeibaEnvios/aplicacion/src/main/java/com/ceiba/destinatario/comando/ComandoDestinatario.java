package com.ceiba.destinatario.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDestinatario {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;
}
