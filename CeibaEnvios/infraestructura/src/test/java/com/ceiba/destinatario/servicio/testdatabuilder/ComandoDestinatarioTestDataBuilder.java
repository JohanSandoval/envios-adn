package com.ceiba.destinatario.servicio.testdatabuilder;

import com.ceiba.destinatario.comando.ComandoDestinatario;

import java.util.UUID;

public class ComandoDestinatarioTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;

    public ComandoDestinatarioTestDataBuilder() {
        this.cedula = "87654321";
        this.nombre = UUID.randomUUID().toString();
        this.apellido = UUID.randomUUID().toString();
        this.ciudad = "MEDELLIN";
        this.direccion = UUID.randomUUID().toString();
    }

    public ComandoDestinatarioTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public ComandoDestinatarioTestDataBuilder conCiudad(String ciudad){
        this.cedula = ciudad;
        return this;
    }

    public ComandoDestinatarioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoDestinatario build(){
        return new ComandoDestinatario(id, cedula, nombre, apellido, ciudad, direccion);
    }
}
