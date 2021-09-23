package com.ceiba.destinatario.servicio.testdatabuilder;

import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.enumeraciones.Ciudad;

public class DestinatarioTestDataBuilder {

    private static final String CEDULA_DESTINATARIO = "202020";
    private static final String NOMBRE_DESTINATARIO = "Karla";
    private static final String APELLIDO_DESTINATARIO = "Duarte";
    private static final String CIUDAD_DESTINATARIO = "BOGOTA";
    private static final String DIRECCION_DESTINATARIO = "AV siempre viva";

    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;

    public DestinatarioTestDataBuilder() {
        this.cedula = CEDULA_DESTINATARIO;
        this.nombre = NOMBRE_DESTINATARIO;
        this.apellido = APELLIDO_DESTINATARIO;
        this.ciudad = CIUDAD_DESTINATARIO;
        this.direccion = DIRECCION_DESTINATARIO;
    }

    public DestinatarioTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public DestinatarioTestDataBuilder conCiudad(String ciudad){
        this.ciudad = ciudad;
        return this;
    }

    public Destinatario build(){
        return new Destinatario(this.cedula, this.nombre, this.apellido, this.ciudad, this.direccion);
    }
}
