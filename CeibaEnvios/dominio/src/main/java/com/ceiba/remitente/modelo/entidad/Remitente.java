package com.ceiba.remitente.modelo.entidad;

import com.ceiba.enumeraciones.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
@AllArgsConstructor
public class Remitente {

    private static final String ID_OBLIGATORIO = "Debe ingresar el id";
    private static final String CEDULA_OBLIGATORIA = "Debe ingresar la cedula";
    private static final String NOMBRE_OBLIGATORIO = "Debe ingresar el nombre";
    private static final String APELLIDO_OBLIGATORIO = "Debe ingresar el apellido";
    private static final String CIUDAD_OBLIGATORIA = "Debe ingresar una ciudad";
    private static final String CIUDAD_INVALIDA = "Debe ingresar una ciudad valida";
    private static final String TELEFONO_OBLIGATORIO = "Debe ingresar el telefono";

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String telefono;

    public Remitente(String cedula, String nombre, String apellido, String ciudad, String telefono) {

        validarObligatorio(cedula, CEDULA_OBLIGATORIA);
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(apellido, APELLIDO_OBLIGATORIO);
        validarObligatorio(ciudad, CIUDAD_OBLIGATORIA);
        validarValido(ciudad.toString(), Ciudad.class, CIUDAD_INVALIDA );
        validarObligatorio(telefono, TELEFONO_OBLIGATORIO);

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = Ciudad.valueOf(ciudad);
        this.telefono = telefono;
    }
}
