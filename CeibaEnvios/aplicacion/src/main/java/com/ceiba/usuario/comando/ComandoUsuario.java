package com.ceiba.usuario.comando;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Long ciudad;
    private String telefono;
}
