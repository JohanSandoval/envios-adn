package com.ceiba.remitente.modelo.dto;

import com.ceiba.enumeraciones.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoRemitente {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String telefono;
}
