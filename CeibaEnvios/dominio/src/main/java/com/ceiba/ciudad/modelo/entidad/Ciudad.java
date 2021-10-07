package com.ceiba.ciudad.modelo.entidad;

import lombok.Getter;
import lombok.ToString;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
public class Ciudad {

    private static final String NOMBRE_OBLIGATORIO = "Se debe ingresar un nombre";

    private Long id;
    private String nombre;

    public Ciudad(Long id, String nombre) {

        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);

        this.id = id;
        this.nombre = nombre;
    }
}
