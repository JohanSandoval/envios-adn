package com.ceiba.usuario.modelo.dto;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private DtoCiudad ciudad;
    private String telefono;

}
