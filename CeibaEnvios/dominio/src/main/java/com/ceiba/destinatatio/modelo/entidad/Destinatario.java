package com.ceiba.destinatatio.modelo.entidad;


import com.ceiba.enumeraciones.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
@AllArgsConstructor
public class Destinatario {

    private static final String CEDULA_OBLIGATORIA = "Debe ingresar la cedula";
    private static final String NOMBRE_OBLIGATORIO = "Debe ingresar el nombre";
    private static final String APELLIDO_OBLIGATORIO = "Debe ingresar el apellido";
    private static final String CIUDAD_OBLIGATORIA = "Debe ingresar una ciudad";
    private static final String CIUDAD_INVALIDA = "Debe ingresar una ciudad valida";
    private static final String DIRECCION_OBLIGATORIA = "Debe ingresar una direccion";

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String direccion;

    public Destinatario(String cedula,String nombre, String apellido, String ciudad, String direccion) {

        validarObligatorio(cedula, CEDULA_OBLIGATORIA);
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(apellido, APELLIDO_OBLIGATORIO);
        validarObligatorio(ciudad, CIUDAD_OBLIGATORIA);
        validarValido(ciudad.toString(), Ciudad.class, CIUDAD_INVALIDA);
        validarObligatorio(direccion, DIRECCION_OBLIGATORIA);

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = Ciudad.valueOf(ciudad);
        this.direccion = direccion;
    }
}
