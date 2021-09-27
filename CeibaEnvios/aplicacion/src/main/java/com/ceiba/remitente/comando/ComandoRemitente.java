package com.ceiba.remitente.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRemitente {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;
}
