package com.ceiba.ciudad.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;

public class CiudadTestDataBuilder {

    private static final String NOMBRE_CIUDAD = "BOGOTA";

    private Long id;
    private String nombre;

    public CiudadTestDataBuilder() {

        this.nombre = NOMBRE_CIUDAD;
    }

    public CiudadTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public CiudadTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public Ciudad build(){
        return new Ciudad(this.id, this.nombre);
    }
}
