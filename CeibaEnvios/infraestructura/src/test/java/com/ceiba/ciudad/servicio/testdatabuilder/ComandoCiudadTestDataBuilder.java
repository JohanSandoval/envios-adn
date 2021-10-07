package com.ceiba.ciudad.servicio.testdatabuilder;

import com.ceiba.ciudad.comando.ComandoCiudad;

public class ComandoCiudadTestDataBuilder {

    private Long id;
    private String nombre;

    public ComandoCiudadTestDataBuilder() {
        this.nombre = "CALI";
    }

    public ComandoCiudadTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoCiudadTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoCiudad build(){
        return new ComandoCiudad(id, nombre);
    }
}
