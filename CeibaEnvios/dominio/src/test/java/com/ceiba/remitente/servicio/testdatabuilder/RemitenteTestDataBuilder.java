package com.ceiba.remitente.servicio.testdatabuilder;

import com.ceiba.enumeraciones.Ciudad;
import com.ceiba.remitente.modelo.entidad.Remitente;

public class RemitenteTestDataBuilder {

    private static final String CEDULA_REMITENTE = "101010";
    private static final String NOMBRE_REMITENTE = "Juan";
    private static final String APELLIDO_REMITENTE = "Perez";
    private static final String TELEFONO_REMITENTE = "5553355";
    private static final String CIUDAD_REMITENTE = "BOGOTA";

    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;

    public RemitenteTestDataBuilder() {

        this.cedula = CEDULA_REMITENTE;
        this.nombre = NOMBRE_REMITENTE;
        this.apellido = APELLIDO_REMITENTE;
        this.ciudad = CIUDAD_REMITENTE;
        this.telefono = TELEFONO_REMITENTE;
    }

    public RemitenteTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public RemitenteTestDataBuilder conCiudad(String ciudad){
        this.ciudad = ciudad;
        return this;
    }

    public Remitente build(){
        return new Remitente(this.cedula, this.nombre, this.apellido, this.ciudad, this.telefono);
    }
}
