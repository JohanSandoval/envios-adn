package com.ceiba.usuario.modelo.entidad;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String CEDULA_OBLIGATORIA = "Se debe de ingresar una cedula";
    private static final String NOMBRE_OBLIGATORIO = "se debe ingresar un nombre";
    private static final String APELLIDO_OBLIGATORIO = "Se debe ingresar un apellido";
    private static final String CIUDAD_OBLIGATORIA = "Se debe ingresar una ciudad valida";
    private static final String TELEFONO_OBLIGATORIO = "Se debe ingresar un telefono";
    private static final String CEDULA_LENG_MAYOR_7 = "La cedula es muy corta la logitud minima es de 8";
    private static final int LONGITUD = 8;

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String telefono;

    public Usuario(Long id, String cedula, String nombre, String apellido, Ciudad ciudad, String telefono) {

        validarObligatorio(cedula, CEDULA_OBLIGATORIA);
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(apellido, APELLIDO_OBLIGATORIO);
        validarObligatorio(ciudad, CIUDAD_OBLIGATORIA);
        validarObligatorio(telefono, TELEFONO_OBLIGATORIO);
        validarLongitud(cedula, LONGITUD, CEDULA_LENG_MAYOR_7);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }
}
