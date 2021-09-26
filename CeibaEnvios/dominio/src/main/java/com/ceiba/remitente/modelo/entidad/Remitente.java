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

    private static final String CEDULA_OBLIGATORIA = "Debe ingresar la cedula";
    private static final String LA_CEDULA_DEBE_SER_MAYOR_O_IGUAL = "la cedula debe tener un longiturd minima de 8";
    private static final String NOMBRE_OBLIGATORIO = "Debe ingresar el nombre";
    private static final String APELLIDO_OBLIGATORIO = "Debe ingresar el apellido";
    private static final String CIUDAD_OBLIGATORIA = "Debe ingresar una ciudad";
    private static final String CIUDAD_INVALIDA = "Debe ingresar una ciudad valida";
    private static final String TELEFONO_OBLIGATORIO = "Debe ingresar el telefono";

    private static final int LONGITUD_MINIMA_CEDULA = 8;

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String telefono;

    public Remitente(Long id,String cedula, String nombre, String apellido, String ciudad, String telefono) {

        validarObligatorio(cedula, CEDULA_OBLIGATORIA);
        validarLongitud(cedula, LONGITUD_MINIMA_CEDULA, LA_CEDULA_DEBE_SER_MAYOR_O_IGUAL);
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(apellido, APELLIDO_OBLIGATORIO);
        validarObligatorio(ciudad, CIUDAD_OBLIGATORIA);
        validarValido(ciudad, Ciudad.class, CIUDAD_INVALIDA );
        validarObligatorio(telefono, TELEFONO_OBLIGATORIO);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = Ciudad.valueOf(ciudad);
        this.telefono = telefono;
    }
}
